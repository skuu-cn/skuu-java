package cn.skuu.controller.api;

import cn.skuu.entity.QqaiWeatherCityDO;
import cn.skuu.pojo.dto.GPSDTO;
import cn.skuu.pojo.vo.ReturnVO;
import cn.skuu.service.IQqaiWeatherCityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/api/qqai-weather-city")
public class QqaiWeatherCityController {

    @Autowired
    private IQqaiWeatherCityService iQqaiWeatherCityService;

    @ApiOperation(value = "根据区域编码获取天气城市")
    @GetMapping("/getByAdCode")
    public ReturnVO<QqaiWeatherCityDO> getByAdCode(@RequestParam Integer adCode) {
        QqaiWeatherCityDO byAdCode = iQqaiWeatherCityService.getByAdCode(adCode);
        return ReturnVO.ok(byAdCode);
    }

    @ApiOperation(value = "根据GPS获取天气城市")
    @GetMapping("/getByGPS")
    public ReturnVO<QqaiWeatherCityDO> getByGPS(GPSDTO gpsDto) {
        QqaiWeatherCityDO byAdCode = iQqaiWeatherCityService.getByGPS(gpsDto);
        return ReturnVO.ok(byAdCode);
    }
}
