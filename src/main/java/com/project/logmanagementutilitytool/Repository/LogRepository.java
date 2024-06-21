package com.project.logmanagementutilitytool.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;

import com.project.logmanagementutilitytool.entity.LogEntity;

// import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntity, String> {
    @Query("{}")
    List<LogEntity> findAll();

    @Query("{'timestamp': {$gte: ?0, $lte: ?1}, 'message': {$regex: ?2}}")
    List<LogEntity> findByDateAndMessage(String startDate, String endDate, String message);



}

