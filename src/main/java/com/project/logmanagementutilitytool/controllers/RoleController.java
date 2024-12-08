package com.project.logmanagementutilitytool.controllers;

import com.project.logmanagementutilitytool.Service.RoleService;
import com.project.logmanagementutilitytool.entity.RoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping
    public ResponseEntity<?> addRole(@RequestBody RoleEntity roleEntity)
    {
        System.out.println("In adding Role");
        return roleService.addRole(roleEntity);

    }

    @DeleteMapping
    public ResponseEntity<?> deleteRole(@RequestParam(required = false) String Rolename, @RequestParam(required = false) String id) {
        if (Rolename == null && id == null) {
            return ResponseEntity.badRequest().build();
        }
        return roleService.deleteRole(Rolename, id);
    }

}
