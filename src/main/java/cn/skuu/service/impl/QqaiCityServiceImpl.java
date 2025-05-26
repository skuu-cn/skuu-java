package cn.skuu.service.impl;

import cn.skuu.entity.QqaiCity;
import cn.skuu.entity.SkuuCity;
import cn.skuu.mapper.QqaiCityMapper;
import cn.skuu.pojo.vo.RefreshCityVo;
import cn.skuu.service.IQqaiCityService;
import cn.skuu.service.ISkuuCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 省市县详细 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
@Service
public class QqaiCityServiceImpl extends ServiceImpl<QqaiCityMapper, QqaiCity> implements IQqaiCityService {


    @Autowired
    private QqaiCityMapper qqaiCityMapper;

    @Override
    public void refreshAdCode() {
        List<RefreshCityVo> refreshCityVos = qqaiCityMapper.getRefreshCityVos();
        for (RefreshCityVo refreshCityVo : refreshCityVos) {
            Integer id = refreshCityVo.getId();
            QqaiCity qqaiCity = getById(id);
            qqaiCity.setAdCode(refreshCityVo.getAdCode());
            updateById(qqaiCity);
        }

    }

    @Override
    public QqaiCity getById(Integer id) {
        return lambdaQuery()
                .eq(QqaiCity::getId, id).one();
    }
}
