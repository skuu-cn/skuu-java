package cn.skuu.service.system.convert.notice;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.skuu.service.system.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.skuu.service.system.controller.admin.notice.vo.NoticeRespVO;
import cn.skuu.service.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.skuu.service.system.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
