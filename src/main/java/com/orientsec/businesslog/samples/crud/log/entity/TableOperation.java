package com.orientsec.businesslog.samples.crud.log.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class TableOperation {
    // 表名称
    private String tablename;
    // 原状态
    private String sourceObject;
    // 目标状态
    private String targetObject;
}
