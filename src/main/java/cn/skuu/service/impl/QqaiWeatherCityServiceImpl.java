package cn.skuu.service.impl;

import cn.skuu.entity.QqaiWeatherCity;
import cn.skuu.mapper.QqaiWeatherCityMapper;
import cn.skuu.service.IQqaiWeatherCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2025-05-26
 */
@Service
public class QqaiWeatherCityServiceImpl extends ServiceImpl<QqaiWeatherCityMapper, QqaiWeatherCity> implements IQqaiWeatherCityService {

    @Override
    public QqaiWeatherCity getByAdCode(Integer adCode) {
        return lambdaQuery()
                .eq(QqaiWeatherCity::getAdCode, adCode)
                .one();
    }
}
