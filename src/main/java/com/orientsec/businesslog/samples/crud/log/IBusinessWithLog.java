package com.orientsec.businesslog.samples.crud.log;

import com.orientsec.businesslog.samples.crud.log.entity.BusinessLogResult;
import com.orientsec.businesslog.samples.crud.log.entity.LogType;

import java.util.List;

public interface IBusinessWithLog {
    //查询
    Object selectById();
    // 更新
    int updateById(Object entity);
    // 保存
    int insert(Object entity);
    // 删除
    int deleteById();

    // 封装数据表变化对象
    List<String> parseTableObject(List<String> tableNames, List<Object> sourceData, List<Object> targetData);

    // 插入数据库操作
    BusinessLogResult insertLog(String operationType, List<String> tableObject, String businessModle, String businessType, String operationDesc);

    // 执行带操作日志插入的动作
    BusinessLogResult executeBusinessWithLog(LogType logType, String operationType, String operationDesc, String businessModle, String businessType,
                                             String tableName, Object... entity);
}
