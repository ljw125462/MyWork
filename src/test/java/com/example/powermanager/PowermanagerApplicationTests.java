package com.example.powermanager;

import com.example.powermanager.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PowermanagerApplicationTests {

    @Resource
    UserDao dao ;
    @Test
    public void contextLoads() {
        dao.changePassword(new Long(1), new BCryptPasswordEncoder().encode("admin"));
    }

}
