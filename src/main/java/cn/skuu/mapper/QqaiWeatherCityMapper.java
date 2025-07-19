package cn.skuu.mapper;

import cn.skuu.entity.QqaiWeatherCityDO;
import cn.skuu.pojo.dto.GPSDTO;
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
public interface QqaiWeatherCityMapper extends BaseMapper<QqaiWeatherCityDO> {

    QqaiWeatherCityDO getByGPS(@Param("gpsDto") GPSDTO gpsDto);
}
