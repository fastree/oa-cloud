package com.fastree.oa.service.aliyun.overtime;

import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OvertimeExcelHandler {

    public static void main(String[] args) {
        // 解析导出的加班清单
        File file = new File("C:\\Users\\Administrator\\Desktop\\AAA\\加班清单2020-11.xlsx");
        OvertimeReadListener overtimeReaderListener = new OvertimeReadListener();
        EasyExcel.read(file, OvertimeReadData.class, overtimeReaderListener).sheet().doRead();


        Map<String, List<OvertimeReadData>> collect = overtimeReaderListener.getDataList()
                .stream()
                .collect(Collectors.groupingBy(OvertimeReadData::getEmpName));

        String[] strings = file.getName().substring(4, 11).split("-");
        LocalDate date = LocalDate.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 1);

        int length = date.getMonth().length(date.isLeapYear());

        if (length == 28) {
            List<OvertimeWrite28Data> dataList = new ArrayList<>();
            collect.forEach((empName, overtimeList) -> {
                OvertimeWrite28Data overtimeData = new OvertimeWrite28Data();
                overtimeList.forEach(overtime -> {
                    overtimeData.setEmpName(overtime.getEmpName());
                    overtimeData.setDeptName(overtime.getDeptName());
                    populate28DayOvertime(overtimeData, LocalDateTime.ofInstant(overtime.getDate().toInstant(), ZoneId.systemDefault()).getDayOfMonth(), overtime.getHours());
                });
                dataList.add(overtimeData);
            });
            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            File write = new File("C:\\Users\\Administrator\\Desktop\\AAA\\" + stamp + ".xlsx");
            EasyExcel.write(write, OvertimeWrite28Data.class).sheet().doWrite(dataList);

        } else if (length == 29) {
            List<OvertimeWrite29Data> dataList = new ArrayList<>();
            collect.forEach((empName, overtimeList) -> {
                OvertimeWrite29Data overtimeData = new OvertimeWrite29Data();
                overtimeList.forEach(overtime -> {
                    overtimeData.setEmpName(overtime.getEmpName());
                    overtimeData.setDeptName(overtime.getDeptName());
                    populate29DayOvertime(overtimeData, LocalDateTime.ofInstant(overtime.getDate().toInstant(), ZoneId.systemDefault()).getDayOfMonth(), overtime.getHours());
                });
                dataList.add(overtimeData);
            });
            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            File write = new File("C:\\Users\\Administrator\\Desktop\\AAA\\" + stamp + ".xlsx");
            EasyExcel.write(write, OvertimeWrite29Data.class).sheet().doWrite(dataList);

        } else if (length == 30) {
            List<OvertimeWrite30Data> dataList = new ArrayList<>();
            collect.forEach((empName, overtimeList) -> {
                OvertimeWrite30Data overtimeData = new OvertimeWrite30Data();
                overtimeList.forEach(overtime -> {
                    overtimeData.setEmpName(overtime.getEmpName());
                    overtimeData.setDeptName(overtime.getDeptName());
                    populate30DayOvertime(overtimeData, LocalDateTime.ofInstant(overtime.getDate().toInstant(), ZoneId.systemDefault()).getDayOfMonth(), overtime.getHours());
                });
                dataList.add(overtimeData);
            });
            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            File write = new File("C:\\Users\\Administrator\\Desktop\\AAA\\" + stamp + ".xlsx");
            EasyExcel.write(write, OvertimeWrite30Data.class).sheet().doWrite(dataList);

        } else if (length == 31) {
            List<OvertimeWrite31Data> dataList = new ArrayList<>();
            collect.forEach((empName, overtimeList) -> {
                OvertimeWrite31Data overtimeData = new OvertimeWrite31Data();
                overtimeList.forEach(overtime -> {
                    overtimeData.setEmpName(overtime.getEmpName());
                    overtimeData.setDeptName(overtime.getDeptName());
                    populate31DayOvertime(overtimeData, LocalDateTime.ofInstant(overtime.getDate().toInstant(), ZoneId.systemDefault()).getDayOfMonth(), overtime.getHours());
                });
                dataList.add(overtimeData);
            });

            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            File write = new File("C:\\Users\\Administrator\\Desktop\\AAA\\" + stamp + ".xlsx");
            EasyExcel.write(write, OvertimeWrite31Data.class).sheet().doWrite(dataList);
        }


    }

    private static void populate28DayOvertime(OvertimeWrite28Data overtimeData, Integer day, Integer hour) {
        if (day == 1) {
            overtimeData.setFirstDay(hour);
        } else if (day == 2) {
            overtimeData.setSecondDay(hour);
        } else if (day == 3) {
            overtimeData.setThirdDay(hour);
        } else if (day == 4) {
            overtimeData.setFourthDay(hour);
        } else if (day == 5) {
            overtimeData.setFifthDay(hour);
        } else if (day == 6) {
            overtimeData.setSixthDay(hour);
        } else if (day == 7) {
            overtimeData.setSeventhDay(hour);
        } else if (day == 8) {
            overtimeData.setEighthDay(hour);
        } else if (day == 9) {
            overtimeData.setNinthDay(hour);
        } else if (day == 10) {
            overtimeData.setTenthDay(hour);
        } else if (day == 11) {
            overtimeData.setEleventhDay(hour);
        } else if (day == 12) {
            overtimeData.setTwelfthDay(hour);
        } else if (day == 13) {
            overtimeData.setThirteenthDay(hour);
        } else if (day == 14) {
            overtimeData.setFourteenthDay(hour);
        } else if (day == 15) {
            overtimeData.setFifteenthDay(hour);
        } else if (day == 16) {
            overtimeData.setSixteenthDay(hour);
        } else if (day == 17) {
            overtimeData.setSeventeenthDay(hour);
        } else if (day == 18) {
            overtimeData.setEighteenthDay(hour);
        } else if (day == 19) {
            overtimeData.setNineteenthDay(hour);
        } else if (day == 20) {
            overtimeData.setTwentiethDay(hour);
        } else if (day == 21) {
            overtimeData.setTwentyFistDay(hour);
        } else if (day == 22) {
            overtimeData.setTwentySecondDay(hour);
        } else if (day == 23) {
            overtimeData.setTwentyThirdDay(hour);
        } else if (day == 24) {
            overtimeData.setTwentyFourthDay(hour);
        } else if (day == 25) {
            overtimeData.setTwentyFifthDay(hour);
        } else if (day == 26) {
            overtimeData.setTwentySixthDay(hour);
        } else if (day == 27) {
            overtimeData.setTwentySeventhDay(hour);
        } else if (day == 28) {
            overtimeData.setTwentyEighthDay(hour);
        }
    }

    private static void populate29DayOvertime(OvertimeWrite29Data overtimeData, Integer day, Integer hour) {
        if (day == 1) {
            overtimeData.setFirstDay(hour);
        } else if (day == 2) {
            overtimeData.setSecondDay(hour);
        } else if (day == 3) {
            overtimeData.setThirdDay(hour);
        } else if (day == 4) {
            overtimeData.setFourthDay(hour);
        } else if (day == 5) {
            overtimeData.setFifthDay(hour);
        } else if (day == 6) {
            overtimeData.setSixthDay(hour);
        } else if (day == 7) {
            overtimeData.setSeventhDay(hour);
        } else if (day == 8) {
            overtimeData.setEighthDay(hour);
        } else if (day == 9) {
            overtimeData.setNinthDay(hour);
        } else if (day == 10) {
            overtimeData.setTenthDay(hour);
        } else if (day == 11) {
            overtimeData.setEleventhDay(hour);
        } else if (day == 12) {
            overtimeData.setTwelfthDay(hour);
        } else if (day == 13) {
            overtimeData.setThirteenthDay(hour);
        } else if (day == 14) {
            overtimeData.setFourteenthDay(hour);
        } else if (day == 15) {
            overtimeData.setFifteenthDay(hour);
        } else if (day == 16) {
            overtimeData.setSixteenthDay(hour);
        } else if (day == 17) {
            overtimeData.setSeventeenthDay(hour);
        } else if (day == 18) {
            overtimeData.setEighteenthDay(hour);
        } else if (day == 19) {
            overtimeData.setNineteenthDay(hour);
        } else if (day == 20) {
            overtimeData.setTwentiethDay(hour);
        } else if (day == 21) {
            overtimeData.setTwentyFistDay(hour);
        } else if (day == 22) {
            overtimeData.setTwentySecondDay(hour);
        } else if (day == 23) {
            overtimeData.setTwentyThirdDay(hour);
        } else if (day == 24) {
            overtimeData.setTwentyFourthDay(hour);
        } else if (day == 25) {
            overtimeData.setTwentyFifthDay(hour);
        } else if (day == 26) {
            overtimeData.setTwentySixthDay(hour);
        } else if (day == 27) {
            overtimeData.setTwentySeventhDay(hour);
        } else if (day == 28) {
            overtimeData.setTwentyEighthDay(hour);
        } else if (day == 29) {
            overtimeData.setTwentyNinthDay(hour);
        }
    }

    private static void populate30DayOvertime(OvertimeWrite30Data overtimeData, Integer day, Integer hour) {
        if (day == 1) {
            overtimeData.setFirstDay(hour);
        } else if (day == 2) {
            overtimeData.setSecondDay(hour);
        } else if (day == 3) {
            overtimeData.setThirdDay(hour);
        } else if (day == 4) {
            overtimeData.setFourthDay(hour);
        } else if (day == 5) {
            overtimeData.setFifthDay(hour);
        } else if (day == 6) {
            overtimeData.setSixthDay(hour);
        } else if (day == 7) {
            overtimeData.setSeventhDay(hour);
        } else if (day == 8) {
            overtimeData.setEighthDay(hour);
        } else if (day == 9) {
            overtimeData.setNinthDay(hour);
        } else if (day == 10) {
            overtimeData.setTenthDay(hour);
        } else if (day == 11) {
            overtimeData.setEleventhDay(hour);
        } else if (day == 12) {
            overtimeData.setTwelfthDay(hour);
        } else if (day == 13) {
            overtimeData.setThirteenthDay(hour);
        } else if (day == 14) {
            overtimeData.setFourteenthDay(hour);
        } else if (day == 15) {
            overtimeData.setFifteenthDay(hour);
        } else if (day == 16) {
            overtimeData.setSixteenthDay(hour);
        } else if (day == 17) {
            overtimeData.setSeventeenthDay(hour);
        } else if (day == 18) {
            overtimeData.setEighteenthDay(hour);
        } else if (day == 19) {
            overtimeData.setNineteenthDay(hour);
        } else if (day == 20) {
            overtimeData.setTwentiethDay(hour);
        } else if (day == 21) {
            overtimeData.setTwentyFistDay(hour);
        } else if (day == 22) {
            overtimeData.setTwentySecondDay(hour);
        } else if (day == 23) {
            overtimeData.setTwentyThirdDay(hour);
        } else if (day == 24) {
            overtimeData.setTwentyFourthDay(hour);
        } else if (day == 25) {
            overtimeData.setTwentyFifthDay(hour);
        } else if (day == 26) {
            overtimeData.setTwentySixthDay(hour);
        } else if (day == 27) {
            overtimeData.setTwentySeventhDay(hour);
        } else if (day == 28) {
            overtimeData.setTwentyEighthDay(hour);
        } else if (day == 29) {
            overtimeData.setTwentyNinthDay(hour);
        } else if (day == 30) {
            overtimeData.setThirtiethDay(hour);
        }
    }

    private static void populate31DayOvertime(OvertimeWrite31Data overtimeData, Integer day, Integer hour) {
        if (day == 1) {
            overtimeData.setFirstDay(hour);
        } else if (day == 2) {
            overtimeData.setSecondDay(hour);
        } else if (day == 3) {
            overtimeData.setThirdDay(hour);
        } else if (day == 4) {
            overtimeData.setFourthDay(hour);
        } else if (day == 5) {
            overtimeData.setFifthDay(hour);
        } else if (day == 6) {
            overtimeData.setSixthDay(hour);
        } else if (day == 7) {
            overtimeData.setSeventhDay(hour);
        } else if (day == 8) {
            overtimeData.setEighthDay(hour);
        } else if (day == 9) {
            overtimeData.setNinthDay(hour);
        } else if (day == 10) {
            overtimeData.setTenthDay(hour);
        } else if (day == 11) {
            overtimeData.setEleventhDay(hour);
        } else if (day == 12) {
            overtimeData.setTwelfthDay(hour);
        } else if (day == 13) {
            overtimeData.setThirteenthDay(hour);
        } else if (day == 14) {
            overtimeData.setFourteenthDay(hour);
        } else if (day == 15) {
            overtimeData.setFifteenthDay(hour);
        } else if (day == 16) {
            overtimeData.setSixteenthDay(hour);
        } else if (day == 17) {
            overtimeData.setSeventeenthDay(hour);
        } else if (day == 18) {
            overtimeData.setEighteenthDay(hour);
        } else if (day == 19) {
            overtimeData.setNineteenthDay(hour);
        } else if (day == 20) {
            overtimeData.setTwentiethDay(hour);
        } else if (day == 21) {
            overtimeData.setTwentyFistDay(hour);
        } else if (day == 22) {
            overtimeData.setTwentySecondDay(hour);
        } else if (day == 23) {
            overtimeData.setTwentyThirdDay(hour);
        } else if (day == 24) {
            overtimeData.setTwentyFourthDay(hour);
        } else if (day == 25) {
            overtimeData.setTwentyFifthDay(hour);
        } else if (day == 26) {
            overtimeData.setTwentySixthDay(hour);
        } else if (day == 27) {
            overtimeData.setTwentySeventhDay(hour);
        } else if (day == 28) {
            overtimeData.setTwentyEighthDay(hour);
        } else if (day == 29) {
            overtimeData.setTwentyNinthDay(hour);
        } else if (day == 30) {
            overtimeData.setThirtiethDay(hour);
        } else if (day == 31) {
            overtimeData.setThirtyFirstDay(hour);
        }
    }


}
