package com.project.logmanagementutilitytool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.logmanagementutilitytool.Service.LogService;
import com.project.logmanagementutilitytool.entity.LogEntity;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/")
    public ResponseEntity<List<LogEntity>> getAllLogs() {
        List<LogEntity> logs = logService.getAllLogs();
        if (logs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @PostMapping("/addlogs")
    public ResponseEntity<?> addLogs( @RequestBody LogEntity logEntity) {
        System.out.println(logEntity);
        return logService.addLogs(logEntity);
    }

}