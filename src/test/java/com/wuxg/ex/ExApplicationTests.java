package com.wuxg.ex;

import com.wuxg.ex.domain.LogStatistics;
import com.wuxg.ex.mapper.LogStatisticsMapper;
import com.wuxg.ex.util.ReadFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExApplicationTests {
    @Autowired
    private LogStatisticsMapper logStatisticsMapper;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testInsert(){
        ReadFile readFile = new ReadFile();
        List list = readFile.readFile();
        HashMap<String, HashMap<String, Long>> statistics = readFile.statistics(list);
        Set<Map.Entry<String, HashMap<String, Long>>> entries = statistics.entrySet();
        Set<String> keys = statistics.keySet();
        for (String key : keys) {
            HashMap<String, Long> vt = statistics.get(key);
            Set<String> version = vt.keySet();
            for (String v : version) {
                Long aLong = vt.get(v);
                LogStatistics logStatistics = new LogStatistics();
                logStatistics.setTime(readFile.strToDate(key));
                logStatistics.setVersion(v);
                logStatistics.setTotal(aLong);
                logStatisticsMapper.insert(logStatistics);
            }
        }

    }

}
