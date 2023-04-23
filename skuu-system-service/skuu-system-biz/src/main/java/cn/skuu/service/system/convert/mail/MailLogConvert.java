package cn.skuu.service.system.convert.mail;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.skuu.service.system.controller.admin.mail.vo.log.MailLogRespVO;
import cn.skuu.service.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
