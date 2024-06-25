package com.project.logmanagementutilitytool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.logmanagementutilitytool.Service.LogService;
import com.project.logmanagementutilitytool.entity.LogEntity;

import java.util.List;
@RestController
@RequestMapping("/api/logsbyparam")
public class LogsByparams {

    @Autowired
    private LogService logService;

    @GetMapping
    public  ResponseEntity<List<LogEntity>> getLogsByDateAndMessage(String startDate, String endDate, String message) {
        List<LogEntity> logs;
        if (startDate == null || endDate == null || message == null) {
            logs = logService.getAllLogs();
        }
        else {
            logs = logService.getLogsByDateAndMessage(startDate, endDate, message);
            if (logs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}