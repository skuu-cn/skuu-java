package cn.skuu.service.impl;

import cn.skuu.entity.SkuuCity;
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
public class SkuuCityServiceImpl extends ServiceImpl<SkuuCityMapper, SkuuCity> implements ISkuuCityService {

    @Override
    public List<SkuuCity> selectByNameAndType(String name, int type) {
       return lambdaQuery().eq(SkuuCity::getName,name)
                .eq(SkuuCity::getType,type)
                .list();
    }
}
