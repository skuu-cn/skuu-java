package cn.skuu.controller.api;

import cn.skuu.entity.QqaiWeatherCityDO;
import cn.skuu.entity.WeatherUserCityDO;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IQqaiWeatherCityService;
import cn.skuu.service.IWeatherUserCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2025-05-31
 */
@Api(tags = "天气-用户-城市")
@RestController
@RequestMapping("/api/weather-user-city")
public class WeatherUserCityController {

    @Autowired
    private IWeatherUserCityService iWeatherUserCityService;

    @Autowired
    private IQqaiWeatherCityService iQqaiWeatherCityService;

     @ApiOperation(value = "详情列表")
    @GetMapping("/detail-list")
    public ReturnVO<List<QqaiWeatherCityDO>> detailList() {
        List<WeatherUserCityDO> list = iWeatherUserCityService.list();
        List<Integer> weatherCityIds = list.stream().map(WeatherUserCityDO::getCityId).collect(Collectors.toList());
        List<QqaiWeatherCityDO> qqaiWeatherCities = iQqaiWeatherCityService.listByIds(weatherCityIds);
        return ReturnVO.ok(qqaiWeatherCities);
    }
}
