package cn.skuu.service;

import cn.skuu.entity.QqaiCityDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 省市县详细 服务类
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
public interface IQqaiCityService extends IService<QqaiCityDO> {

    void refreshAdCode();

    QqaiCityDO getById(Integer id);
}
