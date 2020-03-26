package com.orientsec.businesslog.samples.crud.log.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.orientsec.businesslog.samples.crud.log.IBusinessWithLog;
import com.orientsec.businesslog.samples.crud.log.entity.BusinessLogResult;
import com.orientsec.businesslog.samples.crud.log.entity.BusinessOperation;
import com.orientsec.businesslog.samples.crud.log.entity.LogType;
import com.orientsec.businesslog.samples.crud.log.entity.TableOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
@AllArgsConstructor
public class IBusinessWithLogImpl<T> implements IBusinessWithLog<T> {

    // 继承了BaseMapper的Mapper
    private BaseMapper<T> tMapper;

    @Override
    public T selectById(long id) {
        return tMapper.selectById(id);
    }

    @Override
    public int deleteById(long id) {
        return tMapper.deleteById(id);
    }

    @Override
    public int updateById(T entity) {
        return tMapper.updateById(entity);
    }

    @Override
    public int insert(T entity) {
        return tMapper.insert(entity);
    }

    // 封装数据表变化对象
    @Override
    public List<String> parseTableObject(List<String> tableNames, List<Object> sourceData, List<Object> targetData){
        List<String> tableObject = new ArrayList<String>();
        if(tableNames.size() == sourceData.size() && sourceData.size() == targetData.size()){
            for(int index = 0; index < tableNames.size(); index++){
                TableOperation tableOperation = new TableOperation(tableNames.get(index),
                        JSON.toJSONString(sourceData.get(index)),
                        JSON.toJSONString(targetData.get(index)));
                tableObject.add(JSON.toJSONString(tableOperation));
            }
        }
        return tableObject;
    }

    // 插入数据库操作
    @Override
    public BusinessLogResult insertLog(String operationType, List<String> tableObject,
                                                String businessModle, String businessType, String operationDesc){
        BusinessLogResult businessLogResult = new BusinessLogResult();
        BusinessOperation businessOperation = new BusinessOperation(operationType, businessModle, businessType, operationDesc, tableObject);
        // 没有jar,先模拟
        // BusinessLogResult businessLogResult = JSONObject.parseObject(BusinessLog.insertLog(operationDesc, tableObject, businessModle, businessType, operationDesc));

        // 模拟，先返回一个空的结果
        System.out.println(businessOperation.toString());
        return businessLogResult;
    }

    @Override
    public BusinessLogResult executeBusinessWithLog(long id, LogType logType, String operationType, String operationDesc, String businessModel, String businessType,
                                                    String tableName, T... entity){
        BusinessLogResult businessLogResult = new BusinessLogResult();
        List<String> tableNames = new ArrayList<>();
        List<Object> sourceData = new ArrayList<>();
        List<Object> targetData = new ArrayList<>();
        String emptyJSON = "{}";
        tableNames.add(tableName);

        switch (logType){
            case CREATE:
                insert(entity[0]);
                sourceData.add(emptyJSON);
                targetData.add(entity[0]);
                break;
            case DELETE:
                sourceData.add(selectById(id));
                deleteById(1L);
                targetData.add(emptyJSON);
                break;
            case UPDATE:
                sourceData.add(selectById(id));
                updateById(entity[0]);
                targetData.add(entity[0]);
                break;
        }
        List<String> tableObject = parseTableObject(tableNames,sourceData,targetData);
        businessLogResult = insertLog(operationType, tableObject, businessModel, businessType, operationDesc);
        return businessLogResult;
    }
}
