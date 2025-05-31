package cn.skuu;

import cn.skuu.common.enums.CommonResponseEnum;
import cn.skuu.entity.WeatherUserCity;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IWeatherUserCityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SkuuApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IWeatherUserCityService iWeatherUserCityService;

    @Test
    void contextLoads() throws JsonProcessingException {
        List<WeatherUserCity> list = iWeatherUserCityService.list();
        System.out.println(objectMapper.writeValueAsString(list));
//        String s = objectMapper.writeValueAsString(CommonResponseEnum.ERROR);
        System.out.println(ReturnVO.ok(CommonResponseEnum.SUCCESS));
    }

}
