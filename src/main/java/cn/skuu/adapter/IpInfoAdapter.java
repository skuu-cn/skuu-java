package cn.skuu.adapter;

import cn.skuu.entity.IpInfo;
import cn.skuu.pojo.dto.IpInfoDTO;
import org.mapstruct.Mapper;

/**
 * @author dcx
 * @since 2022-08-30 23:30
 **/
@Mapper(componentModel = "spring")
public interface IpInfoAdapter {

    IpInfo ipInfoDTO2Entity(IpInfoDTO ipInfo);
}
