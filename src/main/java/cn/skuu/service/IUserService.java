package cn.skuu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import cn.skuu.entity.UserDO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dcx
 * @since 2022-08-28
 */
public interface IUserService extends IService<UserDO> {

    UserDO getUser(String userId);

}
