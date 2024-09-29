package com.project.logmanagementutilitytool.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.logmanagementutilitytool.Service.LogService;
import com.project.logmanagementutilitytool.entity.LogEntity;

import java.util.List;

@RestController
@RequestMapping("/api/logsbyparam")
public class LogsByparams {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsByparams.class);

    @Autowired
    private LogService logService;

    @GetMapping
    public ResponseEntity<List<LogEntity>> getLogsByDateAndMessage(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String message,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String resourceId,
            @RequestParam(required = false) String traceId,
            @RequestParam(required = false) String spanId,
            @RequestParam(required = false) String commit,
            @RequestParam(required = false) String metadata) {

        LOGGER.info("Received request with "+ startDate, endDate, message , level, resourceId, traceId, spanId, commit, metadata);

        List<LogEntity> logs;
         {
            logs = logService.getLogsByParams(startDate, endDate, message , level, resourceId, traceId, spanId, commit, metadata);
            if (logs.isEmpty()) {
                LOGGER.warn("No logs found for the given parameters.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        LOGGER.info("Returning {} logs", logs.size());
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}