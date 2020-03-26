package com.orientsec.businesslog.samples.crud.log.entity;

import java.util.List;

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

    public BusinessOperation(String operationType, String businessModle, String businessType, String operationDesc, List<String> tableObject) {
        this.operationType = operationType;
        this.businessModle = businessModle;
        this.businessType = businessType;
        this.operationDesc = operationDesc;
        this.tableObject = tableObject;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getBusinessModle() {
        return businessModle;
    }

    public void setBusinessModle(String businessModle) {
        this.businessModle = businessModle;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public List<String> getTableObject() {
        return tableObject;
    }

    public void setTableObject(List<String> tableObject) {
        this.tableObject = tableObject;
    }
}

