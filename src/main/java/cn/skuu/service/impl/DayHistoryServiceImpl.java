package cn.skuu.service.impl;

import cn.skuu.entity.DayHistoryDO;
import cn.skuu.mapper.DayHistoryMapper;
import cn.skuu.service.IDayHistoryService;
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
public class DayHistoryServiceImpl extends ServiceImpl<DayHistoryMapper, DayHistoryDO> implements IDayHistoryService {

    @Override
    public DayHistoryDO getByDay(String day) {
        return lambdaQuery()
                .eq(DayHistoryDO::getDate, day)
                .one();
    }
}
