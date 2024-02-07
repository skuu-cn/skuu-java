package cn.skuu.service.impl;

import cn.skuu.entity.DayHot;
import cn.skuu.mapper.DayHotMapper;
import cn.skuu.service.IDayHotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每日热点 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
@Service
public class DayHotServiceImpl extends ServiceImpl<DayHotMapper, DayHot> implements IDayHotService {

    @Override
    public DayHot getByDay(String day) {
        return lambdaQuery()
                .eq(DayHot::getDate, day)
                .one();
    }
}
