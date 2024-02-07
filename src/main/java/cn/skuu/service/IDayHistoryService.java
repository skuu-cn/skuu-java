package cn.skuu.service;

import cn.skuu.entity.DayHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 每日热点 服务类
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
public interface IDayHistoryService extends IService<DayHistory> {

    DayHistory getByDay(String day);
}
