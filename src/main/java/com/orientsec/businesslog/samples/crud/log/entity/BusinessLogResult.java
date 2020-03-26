package com.orientsec.businesslog.samples.crud.log.entity;

import lombok.*;

@Data
public class BusinessLogResult {
    // 日志流水号
    private String workFlowNo;
    // 日志记录返回信息
    private String resultMsg;
    // 日志记录返回代码
    private String resultCode;
}
