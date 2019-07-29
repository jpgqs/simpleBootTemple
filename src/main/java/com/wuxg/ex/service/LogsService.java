package com.wuxg.ex.service;

import com.wuxg.ex.domain.LogStatistics;

import java.util.List;

public interface LogsService {

    List<LogStatistics> getLog(String key);
}
