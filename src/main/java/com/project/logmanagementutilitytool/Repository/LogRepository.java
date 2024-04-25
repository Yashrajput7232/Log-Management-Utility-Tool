package com.project.logmanagementutilitytool.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
    @Query("{}")
    List<Log> findAll();
}

