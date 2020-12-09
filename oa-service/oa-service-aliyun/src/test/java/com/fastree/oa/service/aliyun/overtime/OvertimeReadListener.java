package com.fastree.oa.service.aliyun.overtime;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class OvertimeReadListener extends AnalysisEventListener<OvertimeReadData> {
    private List<OvertimeReadData> dataList = new ArrayList<>();

    @Override
    public void invoke(OvertimeReadData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        dataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }
}
