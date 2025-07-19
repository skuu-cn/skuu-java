package cn.skuu.service;

import cn.skuu.entity.SkuuCityDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 省市县 服务类
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
public interface ISkuuCityService extends IService<SkuuCityDO> {

    List<SkuuCityDO> selectByNameAndType(String name, int type);

}
