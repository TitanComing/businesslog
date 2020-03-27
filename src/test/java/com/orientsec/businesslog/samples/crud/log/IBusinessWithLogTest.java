package com.orientsec.businesslog.samples.crud.log;

import com.alibaba.fastjson.JSON;
import com.orientsec.businesslog.samples.crud.entity.User;
import com.orientsec.businesslog.samples.crud.log.entity.BusinessOperation;
import com.orientsec.businesslog.samples.crud.log.entity.LogType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

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
        List<String> tableNames = new ArrayList<>();
        List<User> sourceData = new ArrayList<>();
        List<User> targetData = new ArrayList<>();
        tableNames.add("testTableName");

        User parseUser = new User();
        parseUser.setId(20L);
        parseUser.setName("parseInsert");
        parseUser.setEmail("parseInsert@email.com");
        parseUser.setAge(18);
        sourceData.add(parseUser);

        parseUser.setAge(20);
        targetData.add(parseUser);

//        tableNames.add("testTableName01");
//        sourceData.add(parseUser);
//        targetData.add(parseUser);

        List<String> tableObject = iBusinessWithLog.parseTableObject(tableNames, sourceData, targetData);
        System.out.println(tableObject.toString());
    }

    @Test
    public void insertLog() {
        List<String> tableNames = new ArrayList<>();
        List<User> sourceData = new ArrayList<>();
        List<User> targetData = new ArrayList<>();
        tableNames.add("testTableName");
        User parseUser = new User();
        parseUser.setId(20L);
        parseUser.setName("parseInsert");
        parseUser.setEmail("parseInsert@email.com");
        parseUser.setAge(18);
        sourceData.add(parseUser);
        parseUser.setAge(20);
        targetData.add(parseUser);
        List<String> tableObject = iBusinessWithLog.parseTableObject(tableNames, sourceData, targetData);

        String operationType = "更新";
        String businessModle = "02";
        String businessType = "01";
        String operationDesc = "更新了用户信息";
        BusinessOperation businessOperation = new BusinessOperation(operationType, businessModle, businessType, operationDesc, tableObject);
        System.out.println(JSON.toJSONString(businessOperation));
    }

    @Test
    public void executeBusinessWithLog() {
        String tableName = "测试表";
        String operationType = "测试";
        String businessModle = "02";
        String businessType = "01";
        String operationDesc = "更新了用户信息";

        User businessUser = new User();
        businessUser.setName("businessName");
        businessUser.setEmail("businessName@email.com");
        businessUser.setAge(18);

        iBusinessWithLog.executeBusinessWithLog(LogType.CREATE, tableName,
                operationType, operationDesc, businessModle, businessType,
                businessUser);

        long id = 1L;
        businessUser.setId(id);

        iBusinessWithLog.executeBusinessWithLog(LogType.UPDATE, tableName,
                operationType, operationDesc, businessModle, businessType,
                id, businessUser );

        iBusinessWithLog.executeBusinessWithLog(LogType.DELETE, tableName,
                operationType, operationDesc, businessModle, businessType,
                id);
    }
}