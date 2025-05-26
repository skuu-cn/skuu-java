package cn.skuu.mapper;

import cn.skuu.entity.QqaiCity;
import cn.skuu.pojo.vo.RefreshCityVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 省市县详细 Mapper 接口
 * </p>
 *
 * @author dcx
 * @since 2025-05-25
 */
public interface QqaiCityMapper extends BaseMapper<QqaiCity> {

    List<RefreshCityVo> getRefreshCityVos();
}
