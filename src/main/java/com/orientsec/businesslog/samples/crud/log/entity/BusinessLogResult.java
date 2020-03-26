package com.orientsec.businesslog.samples.crud.log.entity;

public class BusinessLogResult {
    // 日志流水号
    private String workFlowNo;
    // 日志记录返回信息
    private String resultMsg;
    // 日志记录返回代码
    private String resultCode;

    public BusinessLogResult(){}

    public BusinessLogResult(String workFlowNo, String resultMsg, String resultCode) {
        this.workFlowNo = workFlowNo;
        this.resultMsg = resultMsg;
        this.resultCode = resultCode;
    }

    public String getWorkFlowNo() {
        return workFlowNo;
    }

    public void setWorkFlowNo(String workFlowNo) {
        this.workFlowNo = workFlowNo;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "BusinessLogResult{" +
                "workFlowNo='" + workFlowNo + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }
}
