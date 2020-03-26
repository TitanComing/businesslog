package com.orientsec.businesslog.samples.crud.log;

import com.orientsec.businesslog.samples.crud.entity.User;
import com.orientsec.businesslog.samples.crud.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IBusinessWithLogTest {

    @Resource
    IBusinessWithLog<User> iBusinessWithLog;

    @Test
    public void selectById() {
       User user =  iBusinessWithLog.selectById(1L);
       System.out.println(user.toString());
    }

    @Test
    public void updateById() {
        User updateUser = new User();
        updateUser.setId(2L);
        updateUser.setName("testUpdate");
        updateUser.setEmail("testUpdate@email.com");
        updateUser.setAge(18);

        iBusinessWithLog.updateById(updateUser);
        User user = iBusinessWithLog.selectById(2L);
        System.out.println(user.toString());
    }

    @Test
    public void insert() {
        User insertUser = new User();
        insertUser.setName("testInsert");
        insertUser.setEmail("testInsert@email.com");
        insertUser.setAge(18);

        iBusinessWithLog.insert(insertUser);
        System.out.println(iBusinessWithLog.selectById(insertUser.getId()));
    }

    @Test
    public void deleteById() {
        iBusinessWithLog.deleteById(1L);
        assertThat(iBusinessWithLog.selectById(1L)).isNull();

    }

    @Test
    public void parseTableObject() {
    }

    @Test
    public void insertLog() {
    }

    @Test
    public void executeBusinessWithLog() {
    }
}