package com.wuxg.ex.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wuxg.ex.domain.LogStatistics;
import com.wuxg.ex.mapper.LogStatisticsMapper;
import com.wuxg.ex.service.LogsService;
import com.wuxg.ex.util.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogStatisticsMapper logStatisticsMapper;

    @Override
    public List<LogStatistics> getLog(String key) {
        QueryWrapper<LogStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("version",key).or().eq("time",new ReadFile().strToDate(key));
        List<LogStatistics> logStatistics = logStatisticsMapper.selectList(queryWrapper);
//        for(LogStatistics ls:logStatistics){
//           ls.setTime( new ReadFile().strToDate(ls.getTime().toString()) );
//        }
        return logStatistics;
    }
}
