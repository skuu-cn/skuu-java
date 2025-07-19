package cn.skuu.adapter;

import cn.skuu.pojo.vo.UserVo;
import cn.skuu.entity.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserDOAdapterTest {

    @Autowired
    private UserAdapter userAdapter;

    @Test
    void userToUserVo() {
        UserDO build = UserDO.builder()
                .userId("212")
                .status(1)
                .roomId("222")
                .build();
        UserVo userVo = userAdapter.userToUserVo(build);
        System.out.println(userVo);
    }
}