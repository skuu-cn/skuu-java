package cn.skuu.service.impl;

import cn.skuu.adapter.UserAdapter;
import cn.skuu.mapper.UserMapper;
import cn.skuu.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.skuu.entity.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dcx
 * @since 2022-08-28
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAdapter userAdapter;

    @Override
    public UserDO getUser(String userId) {
        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserDO::getUserId, userId);
        queryWrapper.orderByDesc(UserDO::getId);
        queryWrapper.last("limit 1");
        return userMapper.selectOne(queryWrapper);
    }

}
