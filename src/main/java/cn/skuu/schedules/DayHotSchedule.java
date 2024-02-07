package cn.skuu.schedules;

import cn.skuu.entity.DayHistory;
import cn.skuu.pojo.dto.DayHistoryData;
import cn.skuu.pojo.dto.DayHistoryDto;
import cn.skuu.pojo.dto.DayHistoryItem;
import cn.skuu.service.IDayHistoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author dcx
 * @since 2024-02-07 22:54
 **/
@Component
public class DayHotSchedule {

    @Autowired
    private IDayHistoryService iDayHistoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 */1 * * ?")
//    @Scheduled(fixedRate = 20000)
    public void scheduledTask() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://open.tophub.today/daily";
        ResponseEntity<DayHistoryDto> forEntity = restTemplate.getForEntity(url, DayHistoryDto.class);
        if (200 == forEntity.getStatusCode().value()) {
            DayHistoryDto body = forEntity.getBody();
            DayHistoryData data = body.getData();
            String day = data.getDay();
            List<DayHistoryItem> items = data.getToday_in_history();
            String value = objectMapper.writeValueAsString(items);
            DayHistory dayHistoryCur = iDayHistoryService.getByDay(day);
            if (dayHistoryCur == null) {
                DayHistory dayHot = new DayHistory()
                        .setDate(day)
                        .setContent(value);
                iDayHistoryService.save(dayHot);
            } else {
                dayHistoryCur.setContent(value);
                iDayHistoryService.updateById(dayHistoryCur);
            }
        }
    }

}
