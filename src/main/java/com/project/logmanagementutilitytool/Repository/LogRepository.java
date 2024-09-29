package com.project.logmanagementutilitytool.Repository;

import com.project.logmanagementutilitytool.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntity, String> {
    // No custom queries needed here
}
