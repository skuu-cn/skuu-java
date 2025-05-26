package cn.skuu.controller;

import cn.skuu.entity.QqaiWeatherCity;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IQqaiWeatherCityService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
@Api(tags = "天气城市")
@RestController
@RequestMapping("/qqai-weather-city")
public class QqaiWeatherCityController {

    @Autowired
    private IQqaiWeatherCityService iQqaiWeatherCityService;

    @Operation(summary = "根据区域编码获取天气城市")
    @GetMapping("/getByAdCode")
    public ReturnVO<QqaiWeatherCity> getByAdCode(@RequestParam Integer adCode) {
        QqaiWeatherCity byAdCode = iQqaiWeatherCityService.getByAdCode(adCode);
        return ReturnVO.ok(byAdCode);
    }
}
