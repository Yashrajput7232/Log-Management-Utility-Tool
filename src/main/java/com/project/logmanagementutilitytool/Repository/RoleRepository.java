package com.project.logmanagementutilitytool.Repository;

import com.project.logmanagementutilitytool.entity.RoleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<RoleEntity, String> {
    void deleteByRoleName(String roleName);

    RoleEntity getRoleEntityByRoleName(String rolename);

    // No custom queries needed here
}
