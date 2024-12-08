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
    @GetMapping("/getallRoles")
    public ResponseEntity<?> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addRole(@RequestBody RoleEntity roleEntity)
    {
        System.out.println("In adding Role");
        return roleService.addRole(roleEntity);

    }

    @DeleteMapping("/delete/{Rolename}")
    public ResponseEntity<?> deleteRole(@PathVariable String Rolename) {
        return roleService.deleteRole(Rolename);
    }

}
