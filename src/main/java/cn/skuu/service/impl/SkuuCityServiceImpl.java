package cn.skuu.service.impl;

import cn.skuu.entity.SkuuCityDO;
import cn.skuu.mapper.SkuuCityMapper;
import cn.skuu.service.ISkuuCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 省市县 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
@Service
public class SkuuCityServiceImpl extends ServiceImpl<SkuuCityMapper, SkuuCityDO> implements ISkuuCityService {

    @Override
    public List<SkuuCityDO> selectByNameAndType(String name, int type) {
       return lambdaQuery().eq(SkuuCityDO::getName,name)
                .eq(SkuuCityDO::getType,type)
                .list();
    }
}
