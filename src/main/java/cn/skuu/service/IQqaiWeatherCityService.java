package cn.skuu.service;

import cn.skuu.entity.QqaiWeatherCity;
import cn.skuu.pojo.dto.GPSDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
public interface IQqaiWeatherCityService extends IService<QqaiWeatherCity> {

    QqaiWeatherCity getByAdCode(Integer adCode);

    QqaiWeatherCity getByGPS(GPSDto gpsDto);
}
