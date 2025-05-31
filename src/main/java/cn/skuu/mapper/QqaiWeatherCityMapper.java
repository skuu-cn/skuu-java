package cn.skuu.mapper;

import cn.skuu.entity.QqaiWeatherCity;
import cn.skuu.pojo.dto.GPSDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
public interface QqaiWeatherCityMapper extends BaseMapper<QqaiWeatherCity> {

    QqaiWeatherCity getByGPS(@Param("gpsDto") GPSDto gpsDto);
}
