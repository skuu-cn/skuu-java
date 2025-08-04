package cn.skuu.service;

import cn.skuu.entity.QqaiWeatherCityDO;
import cn.skuu.pojo.dto.GPSDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
public interface IQqaiWeatherCityService extends IService<QqaiWeatherCityDO> {

    QqaiWeatherCityDO getByAdCode(Integer adCode);

    QqaiWeatherCityDO getByGPS(GPSDTO gpsDto);
}
