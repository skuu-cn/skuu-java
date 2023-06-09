package cn.skuu.infra.convert.db;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.skuu.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import cn.skuu.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import cn.skuu.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.infra.controller.admin.db.vo.*;
import cn.skuu.infra.dal.dataobject.db.DataSourceConfigDO;

/**
 * 数据源配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
