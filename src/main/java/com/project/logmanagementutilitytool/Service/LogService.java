package com.project.logmanagementutilitytool.Service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.stereotype.Service;

import com.project.logmanagementutilitytool.Repository.LogRepository;
import com.project.logmanagementutilitytool.entity.LogEntity;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<LogEntity> getAllLogs() {
        return logRepository.findAll();
    }
}
