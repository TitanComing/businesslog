package com.orientsec.businesslog.samples.crud.log;

import com.orientsec.businesslog.samples.crud.log.entity.BusinessLogResult;
import com.orientsec.businesslog.samples.crud.log.entity.LogType;

import java.util.List;

public interface IBusinessWithLog<T> {
    //查询
    T selectById(long id);
    // 更新
    int updateById(T entity);
    // 保存
    int insert(T entity);
    // 删除
    int deleteById(long id);

    // 封装数据表变化对象
    List<String> parseTableObject(List<String> tableNames, List<T> sourceData, List<T> targetData);

    // 插入数据库操作
    BusinessLogResult insertLog(String operationType, List<String> tableObject, String businessModle, String businessType, String operationDesc);

    // 执行带操作日志的动作: update
    BusinessLogResult executeBusinessWithLog(LogType logType, String tableName, String operationType, String operationDesc, String businessModel, String businessType,
                                             long id, T entity);
    // 执行带操作日志的动作: delete
    BusinessLogResult executeBusinessWithLog(LogType logType, String tableName, String operationType, String operationDesc, String businessModel, String businessType,
                                             long id);
    // 执行带操作日志的动作: create
    BusinessLogResult executeBusinessWithLog(LogType logType, String tableName, String operationType, String operationDesc, String businessModel, String businessType,
                                             T entity);
}
