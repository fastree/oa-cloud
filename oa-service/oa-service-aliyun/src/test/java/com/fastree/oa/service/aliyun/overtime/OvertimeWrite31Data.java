package com.fastree.oa.service.aliyun.overtime;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class OvertimeWrite31Data {
    @ExcelProperty("姓名")
    private String empName;
    @ExcelProperty("部门")
    private String deptName;

    @ExcelProperty("1")
    private Integer firstDay = new Integer(0);
    @ExcelProperty("2")
    private Integer secondDay = new Integer(0);
    @ExcelProperty("3")
    private Integer thirdDay = new Integer(0);
    @ExcelProperty("4")
    private Integer fourthDay = new Integer(0);
    @ExcelProperty("5")
    private Integer fifthDay = new Integer(0);
    @ExcelProperty("6")
    private Integer sixthDay = new Integer(0);
    @ExcelProperty("7")
    private Integer seventhDay = new Integer(0);
    @ExcelProperty("8")
    private Integer eighthDay = new Integer(0);
    @ExcelProperty("9")
    private Integer ninthDay = new Integer(0);
    @ExcelProperty("10")
    private Integer tenthDay = new Integer(0);
    @ExcelProperty("11")
    private Integer eleventhDay = new Integer(0);
    @ExcelProperty("12")
    private Integer twelfthDay = new Integer(0);
    @ExcelProperty("13")
    private Integer thirteenthDay = new Integer(0);
    @ExcelProperty("14")
    private Integer fourteenthDay = new Integer(0);
    @ExcelProperty("15")
    private Integer fifteenthDay = new Integer(0);
    @ExcelProperty("16")
    private Integer sixteenthDay = new Integer(0);
    @ExcelProperty("17")
    private Integer seventeenthDay = new Integer(0);
    @ExcelProperty("18")
    private Integer eighteenthDay = new Integer(0);
    @ExcelProperty("19")
    private Integer nineteenthDay = new Integer(0);
    @ExcelProperty("20")
    private Integer twentiethDay = new Integer(0);
    @ExcelProperty("21")
    private Integer twentyFistDay = new Integer(0);
    @ExcelProperty("22")
    private Integer twentySecondDay = new Integer(0);
    @ExcelProperty("23")
    private Integer twentyThirdDay = new Integer(0);
    @ExcelProperty("24")
    private Integer twentyFourthDay = new Integer(0);
    @ExcelProperty("25")
    private Integer twentyFifthDay = new Integer(0);
    @ExcelProperty("26")
    private Integer twentySixthDay = new Integer(0);
    @ExcelProperty("27")
    private Integer twentySeventhDay = new Integer(0);
    @ExcelProperty("28")
    private Integer twentyEighthDay = new Integer(0);
    @ExcelProperty("29")
    private Integer twentyNinthDay = new Integer(0);
    @ExcelProperty("30")
    private Integer thirtiethDay = new Integer(0);
    @ExcelProperty("31")
    private Integer thirtyFirstDay = new Integer(0);
}
