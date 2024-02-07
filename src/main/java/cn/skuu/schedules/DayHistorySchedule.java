package cn.skuu.schedules;

import cn.skuu.entity.DayHot;
import cn.skuu.pojo.dto.DayHotData;
import cn.skuu.pojo.dto.DayHotDto;
import cn.skuu.pojo.dto.DayHotItem;
import cn.skuu.service.IDayHotService;
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
public class DayHistorySchedule {

    @Autowired
    private IDayHotService iDayHotService;

    @Autowired
    private ObjectMapper objectMapper;

        @Scheduled(cron = "0 0 */1 * * ?")
//    @Scheduled(fixedRate = 20000)
    public void scheduledTask() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://open.tophub.today/hot";
        ResponseEntity<DayHotDto> forEntity = restTemplate.getForEntity(url, DayHotDto.class);
        if (200 == forEntity.getStatusCode().value()) {
            DayHotDto body = forEntity.getBody();
            DayHotData data = body.getData();
            String day = data.getDay().replace("-","");
            List<DayHotItem> items = data.getItems();
            String value = objectMapper.writeValueAsString(items);
            DayHot dayHotCur = iDayHotService.getByDay(day);
            if (dayHotCur == null) {
                DayHot dayHot = new DayHot()
                        .setDate(day)
                        .setContent(value);
                iDayHotService.save(dayHot);
            } else {
                dayHotCur.setContent(value);
                iDayHotService.updateById(dayHotCur);
            }
        }
    }

}
