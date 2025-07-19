package cn.skuu.manager.schedules;

import cn.skuu.entity.DayHistoryDO;
import cn.skuu.pojo.dto.DayHistoryDataDTO;
import cn.skuu.pojo.dto.DayHistoryDTO;
import cn.skuu.pojo.dto.DayHistoryItemDTO;
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
public class DayHistorySchedule {

    @Autowired
    private IDayHistoryService iDayHistoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 */1 * * ?")
//    @Scheduled(fixedRate = 20000)
    public void scheduledTask() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://open.tophub.today/daily";
        ResponseEntity<DayHistoryDTO> forEntity = restTemplate.getForEntity(url, DayHistoryDTO.class);
        if (200 == forEntity.getStatusCode().value()) {
            DayHistoryDTO body = forEntity.getBody();
            DayHistoryDataDTO data = body.getData();
            String day = data.getDay().replace("-","");
            List<DayHistoryItemDTO> items = data.getToday_in_history();
            String value = objectMapper.writeValueAsString(items);
            DayHistoryDO dayHistoryDOCur = iDayHistoryService.getByDay(day);
            if (dayHistoryDOCur == null) {
                DayHistoryDO dayHot = new DayHistoryDO()
                        .setDate(day)
                        .setContent(value);
                iDayHistoryService.save(dayHot);
            } else {
                dayHistoryDOCur.setContent(value);
                iDayHistoryService.updateById(dayHistoryDOCur);
            }
        }
    }

}
