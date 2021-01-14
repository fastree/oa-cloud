package com.fastree.oa.service.aliyun.leave;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class LeaveWriteData {
    @ExcelProperty("申请人")
    private String empName;
    @ExcelProperty("部门")
    private String deptName;
    @ExcelProperty("带薪病假")
    private Double sickLeaveWithPay = new Double(0);
    @ExcelProperty("病假")
    private Double sickLeave = new Double(0);;
    @ExcelProperty("年假")
    private Double annualLeave = new Double(0);;
    @ExcelProperty("调休")
    private Double restLeave = new Double(0);;
    @ExcelProperty("事假")
    private Double personalLeave = new Double(0);;
    @ExcelProperty("婚假")
    private Double marriageLeave = new Double(0);;
    @ExcelProperty("产假")
    private Double maternityLeave = new Double(0);;
    @ExcelProperty("哺乳假")
    private Double breastFeedingLeave = new Double(0);;
    @ExcelProperty("陪产假")
    private Double paternityLeave = new Double(0);;
    @ExcelProperty("丧假")
    private Double funeralLeave = new Double(0);;
}
