package com.project.logmanagementutilitytool.Repository;

import com.project.logmanagementutilitytool.entity.UserEntity;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
    void deleteByUsername(@NotBlank String username);

    Optional<UserEntity> findByUsername(@NotBlank String username);
}
