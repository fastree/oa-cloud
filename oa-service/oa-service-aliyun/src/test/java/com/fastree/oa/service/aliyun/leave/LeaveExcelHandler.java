package com.fastree.oa.service.aliyun.leave;

import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LeaveExcelHandler {

    public static void main(String[] args) {
        // 解析导出的加班清单
        File file = new File("C:\\Users\\Administrator\\Desktop\\AAA\\请假清单2020-12.xlsx");
        LeaveReadListener leaveReadListener = new LeaveReadListener();
        EasyExcel.read(file, LeaveReadData.class, leaveReadListener).sheet().doRead();

        List<LeaveReadData> dataList = leaveReadListener.getDataList();
//        dataList.forEach(leaveReadData -> {
//            System.out.println(leaveReadData);
//        });

        // 全部待写入的数据
        List<LeaveWriteData> writeDataList = new ArrayList<>();

        dataList.stream()
                .collect(Collectors.groupingBy(LeaveReadData::getDeptName))
                .entrySet()
                .forEach(deptEntry -> {
                    System.out.println("***************正在处理(" + deptEntry.getKey() + ")***************");
                    List<LeaveReadData> deptList = deptEntry.getValue();
                    deptList.stream()
                            .collect(Collectors.groupingBy(LeaveReadData::getEmpName))
                            .entrySet()
                            .forEach(empEntry -> {
                                String empName = empEntry.getKey();
                                List<LeaveReadData> empList = empEntry.getValue();
                                // 每个员工所有的假期为一条记录
                                LeaveWriteData writeData = new LeaveWriteData();
                                writeData.setEmpName(empName);
                                writeData.setDeptName(empList.get(0).getDeptName());

                                System.out.println("正在处理(" + empName + ")");
                                empList.stream()
                                        .collect(Collectors.groupingBy(LeaveReadData::getLeaveType))
                                        .entrySet()
                                        .forEach(leaveEntry -> {

                                            String leaveType = leaveEntry.getKey().trim();
                                            List<LeaveReadData> leaveTypeList = leaveEntry.getValue();

                                            Double leaveDuration = leaveTypeList.stream()
                                                    .map(LeaveReadData::getLeaveDuration)
                                                    .reduce(0d, Double::sum);
                                            System.out.println("  ==> " + leaveType + " : " + leaveDuration);

                                            processLeaveNode(writeData, leaveType, leaveDuration);
                                        });

                                writeDataList.add(writeData);
                            });
                });

        writeDataList.forEach(System.out::println);

        String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        File write = new File("C:\\Users\\Administrator\\Desktop\\AAA\\" + file.getName().split("\\.")[0] + "_" + stamp + ".xlsx");
        EasyExcel.write(write, LeaveWriteData.class).sheet().doWrite(writeDataList);
    }

    private static void processLeaveNode(LeaveWriteData writeData, String leaveType, Double leaveDuration) {
        if ("带薪病假".equalsIgnoreCase(leaveType)) {
            writeData.setSickLeaveWithPay(leaveDuration);
        } else if ("病假".equalsIgnoreCase(leaveType)) {
            writeData.setSickLeave(leaveDuration);
        } else if ("年假".equalsIgnoreCase(leaveType)) {
            writeData.setAnnualLeave(leaveDuration);
        } else if ("调休".equalsIgnoreCase(leaveType)) {
            writeData.setRestLeave(leaveDuration);
        } else if ("事假".equalsIgnoreCase(leaveType)) {
            writeData.setPersonalLeave(leaveDuration);
        } else if ("婚假".equalsIgnoreCase(leaveType)) {
            writeData.setMarriageLeave(leaveDuration);
        } else if ("产假".equalsIgnoreCase(leaveType)) {
            writeData.setMaternityLeave(leaveDuration);
        } else if ("哺乳假".equalsIgnoreCase(leaveType)) {
            writeData.setBreastFeedingLeave(leaveDuration);
        } else if ("陪产假".equalsIgnoreCase(leaveType)) {
            writeData.setPaternityLeave(leaveDuration);
        } else if ("丧假".equalsIgnoreCase(leaveType)) {
            writeData.setFuneralLeave(leaveDuration);
        }
    }
}
