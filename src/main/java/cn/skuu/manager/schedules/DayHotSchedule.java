package cn.skuu.manager.schedules;

import cn.skuu.entity.DayHotDO;
import cn.skuu.pojo.dto.DayHotDataDTO;
import cn.skuu.pojo.dto.DayHotDTO;
import cn.skuu.pojo.dto.DayHotItemDTO;
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
public class DayHotSchedule {

    @Autowired
    private IDayHotService iDayHotService;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(cron = "0 0 */1 * * ?")
//    @Scheduled(fixedRate = 20000)
    public void scheduledTask() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://open.tophub.today/hot";
        ResponseEntity<DayHotDTO> forEntity = restTemplate.getForEntity(url, DayHotDTO.class);
        if (200 == forEntity.getStatusCode().value()) {
            DayHotDTO body = forEntity.getBody();
            DayHotDataDTO data = body.getData();
            String day = data.getDay().replace("-", "");
            List<DayHotItemDTO> items = data.getItems();
            String value = objectMapper.writeValueAsString(items);
            DayHotDO dayHotDOCur = iDayHotService.getByDay(day);
            if (dayHotDOCur == null) {
                DayHotDO dayHotDO = new DayHotDO()
                        .setDate(day)
                        .setContent(value);
                iDayHotService.save(dayHotDO);
            } else {
                dayHotDOCur.setContent(value);
                iDayHotService.updateById(dayHotDOCur);
            }
        }
    }

}
