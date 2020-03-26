package com.orientsec.businesslog.samples.crud.log.entity;

public class TableOperation {
    // 表名称
    private String tablename;
    // 原状态
    private String sourceObject;
    // 目标状态
    private String targetObject;

    public TableOperation(String tablename, String sourceObject, String targetObject) {
        this.tablename = tablename;
        this.sourceObject = sourceObject;
        this.targetObject = targetObject;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getSourceObject() {
        return sourceObject;
    }

    public void setSourceObject(String sourceObject) {
        this.sourceObject = sourceObject;
    }

    public String getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public String toString() {
        return "tableOperationObject{" +
                "tablename='" + tablename + '\'' +
                ", sourceObject='" + sourceObject + '\'' +
                ", targetObject='" + targetObject + '\'' +
                '}';
    }
}
