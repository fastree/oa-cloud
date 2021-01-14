package com.fastree.oa.service.aliyun.overtime;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class OvertimeWrite28Data {
    @ExcelProperty("姓名")
    private String empName;
    @ExcelProperty("部门")
    private String deptName;

    @ExcelProperty("1")
    private Double firstDay = new Double(0);
    @ExcelProperty("2")
    private Double secondDay = new Double(0);
    @ExcelProperty("3")
    private Double thirdDay = new Double(0);
    @ExcelProperty("4")
    private Double fourthDay = new Double(0);
    @ExcelProperty("5")
    private Double fifthDay = new Double(0);
    @ExcelProperty("6")
    private Double sixthDay = new Double(0);
    @ExcelProperty("7")
    private Double seventhDay = new Double(0);
    @ExcelProperty("8")
    private Double eighthDay = new Double(0);
    @ExcelProperty("9")
    private Double ninthDay = new Double(0);
    @ExcelProperty("10")
    private Double tenthDay = new Double(0);
    @ExcelProperty("11")
    private Double eleventhDay = new Double(0);
    @ExcelProperty("12")
    private Double twelfthDay = new Double(0);
    @ExcelProperty("13")
    private Double thirteenthDay = new Double(0);
    @ExcelProperty("14")
    private Double fourteenthDay = new Double(0);
    @ExcelProperty("15")
    private Double fifteenthDay = new Double(0);
    @ExcelProperty("16")
    private Double sixteenthDay = new Double(0);
    @ExcelProperty("17")
    private Double seventeenthDay = new Double(0);
    @ExcelProperty("18")
    private Double eighteenthDay = new Double(0);
    @ExcelProperty("19")
    private Double nineteenthDay = new Double(0);
    @ExcelProperty("20")
    private Double twentiethDay = new Double(0);
    @ExcelProperty("21")
    private Double twentyFistDay = new Double(0);
    @ExcelProperty("22")
    private Double twentySecondDay = new Double(0);
    @ExcelProperty("23")
    private Double twentyThirdDay = new Double(0);
    @ExcelProperty("24")
    private Double twentyFourthDay = new Double(0);
    @ExcelProperty("25")
    private Double twentyFifthDay = new Double(0);
    @ExcelProperty("26")
    private Double twentySixthDay = new Double(0);
    @ExcelProperty("27")
    private Double twentySeventhDay = new Double(0);
    @ExcelProperty("28")
    private Double twentyEighthDay = new Double(0);
}
