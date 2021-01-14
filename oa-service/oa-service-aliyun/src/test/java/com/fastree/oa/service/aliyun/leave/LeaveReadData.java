package com.fastree.oa.service.aliyun.leave;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class LeaveReadData {
    @ExcelProperty("申请人")
    private String empName;
    @ExcelProperty("部门")
    private String deptName;
    @ExcelProperty("开始时间")
    private String startDate;
    @ExcelProperty("结束时间")
    private String endDate;
    @ExcelProperty("请假时间")
    private Double leaveDuration;
    @ExcelProperty("请假类型")
    private String leaveType;
    @ExcelProperty("请假原因")
    private String leaveReason;
}
