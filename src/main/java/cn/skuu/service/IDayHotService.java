package cn.skuu.service;

import cn.skuu.entity.DayHot;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 每日热点 服务类
 * </p>
 *
 * @author dcx
 * @since 2024-02-07
 */
public interface IDayHotService extends IService<DayHot> {

    DayHot getByDay(String day);
}
