package com.project.logmanagementutilitytool.Service;

import com.project.logmanagementutilitytool.Repository.RoleRepository;
import com.project.logmanagementutilitytool.entity.RoleEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    public ResponseEntity<?> getAllRoles(){
        List<RoleEntity> roles = roleRepository.findAll();
        return ResponseEntity.ok(roles);
    }

    public ResponseEntity<RoleEntity> addRole(RoleEntity roleEntity) {
        RoleEntity savedRole = roleRepository.save(roleEntity);
        return ResponseEntity.ok(savedRole);
    }
    public  ResponseEntity<RoleEntity> deleteRole(String name){
        roleRepository.deleteByRoleName(name);
        return ResponseEntity.ok().build();
    }
}