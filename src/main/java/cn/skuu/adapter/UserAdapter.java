package cn.skuu.adapter;

import cn.skuu.pojo.vo.UserVo;
import cn.skuu.entity.UserDO;
import cn.skuu.pojo.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 *
 * @author dcx
 * @since 2022-08-30 23:30
 **/
@Mapper(componentModel = "spring")
public interface UserAdapter {

    UserVo userToUserVo(UserDO userDO);

    List<UserDO> userDtosToUsers(List<UserDTO> inviters);

    List<UserVo> usersToUserVos(List<UserDO> userDOS);
}
