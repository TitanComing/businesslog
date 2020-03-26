package com.orientsec.businesslog.samples.crud.log.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class BusinessOperation {
    // 操作类型：01-新增，02-修改，03-删除
    private String operationType;
    // 业务模块
    private String businessModle;
    // 业务类型
    private String businessType;
    // 操作描述
    private String operationDesc;
    // 修改前后记录数据库变化的json字符串对象
    private List<String> tableObject;
}

