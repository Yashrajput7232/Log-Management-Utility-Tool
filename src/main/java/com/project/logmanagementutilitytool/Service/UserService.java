package com.project.logmanagementutilitytool.Service;

import com.project.logmanagementutilitytool.Repository.UserRepository;
import com.project.logmanagementutilitytool.entity.RoleEntity;
import com.project.logmanagementutilitytool.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  RoleService roleService;

    public ResponseEntity<?> getAllUsers(){
        List<UserEntity> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<?> addUser(UserEntity userEntity){

        Optional<UserEntity> existingUser= userRepository.findByUsername(userEntity.getUsername());
        if(existingUser.isPresent()){
            return ResponseEntity.badRequest().body("User already exists");
        }
        for (RoleEntity role : userEntity.getRoles()) {

            if (roleService.getRole(role.getRoleName())!=null) {
                role.setId(roleService.getRole(role.getRoleName()).getId());;
            } else {
                return   ResponseEntity.badRequest().body("Role does not exist");
            }
        }
        UserEntity user = userRepository.save(userEntity);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> deleteUser(String username){
        userRepository.deleteByUsername(username);
        return ResponseEntity.ok("User deleted successfully");
    }
    public ResponseEntity<?> updateUser(UserEntity userEntity){
        UserEntity user = userRepository.save(userEntity);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<?> getUser(String username){
        return ResponseEntity.ok(userRepository.findById(username));
    }
}
