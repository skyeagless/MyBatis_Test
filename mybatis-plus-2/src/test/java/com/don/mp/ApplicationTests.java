package com.don.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.don.mp.dao.UserMapper;
import com.don.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deletedById() {
        int rows = userMapper.deleteById(1094592041087729666L);
        System.out.println(rows);
    }

    @Test
    public void select() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void mySelect() {
        List<User> list = userMapper.mySelectList(Wrappers.<User>lambdaQuery()
                .gt(User::getAge, 25)
                .eq(User::getDeleted, 0));
        list.forEach(System.out::println);
    }

    @Test
    public void contextLoads() {
    }

}
