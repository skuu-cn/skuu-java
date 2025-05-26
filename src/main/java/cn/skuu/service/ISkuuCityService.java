package cn.skuu.service;

import cn.skuu.entity.SkuuCity;
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
public interface ISkuuCityService extends IService<SkuuCity> {

    List<SkuuCity> selectByNameAndType(String name, int type);

}
