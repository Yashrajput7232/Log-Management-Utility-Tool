package com.project.logmanagementutilitytool.Service;
import com.project.logmanagementutilitytool.controllers.LogsByparams;
import com.project.logmanagementutilitytool.entity.LogEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import com.project.logmanagementutilitytool.Repository.LogRepository;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LogsByparams.class);

    // Get all logs (no filters)
    public Page<LogEntity> getAllLogs(Pageable pageable) {
        long total=logRepository.count();
        List<LogEntity> logs = logRepository.findAll(pageable).getContent();
        return new PageImpl<>(logs, pageable, total);
    }

    // Dynamically filter logs based on provided params
    public Page<LogEntity> getLogsByParams(String startDate, String endDate, String message, String level,
                                           String resourceId, String traceId, String spanId, String commit, String metadata,Pageable pageable) {
        Query query = new Query();

        // Add criteria only for non-null parameters
        if (startDate != null && endDate != null) {
            query.addCriteria(Criteria.where("timestamp").gte(startDate).lte(endDate));
        }
        if (message != null) {
            query.addCriteria(Criteria.where("message").regex(message, "i"));  // Case-insensitive regex
        }
        if (level != null) {
            query.addCriteria(Criteria.where("level").is(level));
        }
        if (resourceId != null) {
            query.addCriteria(Criteria.where("resourceId").is(resourceId));
        }
        if (traceId != null) {
            query.addCriteria(Criteria.where("traceId").is(traceId));
        }
        if (spanId != null) {
            query.addCriteria(Criteria.where("spanId").is(spanId));
        }
        if (commit != null) {
            query.addCriteria(Criteria.where("commit").is(commit));
        }
        if (metadata != null) {
            query.addCriteria(Criteria.where("metadata.parentResourceId").is(metadata));
        }

        query.with(Sort.by(Sort.Order.desc("timestamp")));  // Sort by timestamp in descending order

        LOGGER.info("Generated query: " + query.toString());

        // Execute query and return paginated results
        long total = mongoTemplate.count(query, LogEntity.class);
        List<LogEntity> logs = mongoTemplate.find(query.with(pageable), LogEntity.class);
        return new PageImpl<>(logs, pageable, total);
    }

    // Add new log entry
    public ResponseEntity<?> addLogs(LogEntity logEntity) {
        LogEntity savedLog = logRepository.save(logEntity);
        return new ResponseEntity<>(savedLog, HttpStatus.OK);
    }
}
