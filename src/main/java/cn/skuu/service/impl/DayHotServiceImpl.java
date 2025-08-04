package cn.skuu.service.impl;

import cn.skuu.entity.DayHotDO;
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
public class DayHotServiceImpl extends ServiceImpl<DayHotMapper, DayHotDO> implements IDayHotService {

    @Override
    public DayHotDO getByDay(String day) {
        return lambdaQuery()
                .eq(DayHotDO::getDate, day)
                .one();
    }
}
