package com.wuxg.ex.controller;

import com.wuxg.ex.domain.LogStatistics;
import com.wuxg.ex.service.LogsService;
import com.wuxg.ex.util.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("logs")
public class LogController {

    @Autowired
    private LogsService logsService;

    @RequestMapping("/get/{key}")
    public Object logs(@PathVariable("key") String keyWord){
        List<LogStatistics> log = logsService.getLog(keyWord);
        return log;
    }

}
