package com.project.logmanagementutilitytool.Service;

import com.project.logmanagementutilitytool.DTO.UserDTO;
import com.project.logmanagementutilitytool.Repository.UserRepository;
import com.project.logmanagementutilitytool.entity.RoleEntity;
import com.project.logmanagementutilitytool.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
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
//    public ResponseEntity<?> getUser(String username){
//        return ResponseEntity.ok(userRepository.findByUsername(username));
//    }

    public ResponseEntity<?> modifyRoles(String username , String Action, String roleName) {
        {
            Optional<UserEntity> user = userRepository.findByUsername(username);
            if (user.isEmpty()) {
                return ResponseEntity.badRequest().body("User does not exist");
            }
            Set<RoleEntity> existingRoles = user.get().getRoles();
            RoleEntity role_=roleService.getRole(roleName);
            if (Objects.equals(Action, "add")) {
                if (existingRoles.contains(roleService.getRole(roleName))) {
                    return ResponseEntity.badRequest().body("Role already exists");
                }
                RoleEntity role = roleService.getRole(roleName);
                if (role == null) {
                    return ResponseEntity.badRequest().body("Role does not exist");
                }
                user.get().getRoles().add(role);
            }
            else if (Objects.equals(Action, "remove")) {
                if (!existingRoles.contains(roleService.getRole(roleName))) {
                    return ResponseEntity.badRequest().body("User does not have this role");
                }
                RoleEntity role = roleService.getRole(roleName);
                if (role == null) {
                    return ResponseEntity.badRequest().body("Role does not exist");
                }
                user.get().getRoles().remove(role);
            }
            userRepository.save(user.get());
            return ResponseEntity.ok(user);
        }


    }

    public ResponseEntity<?> getUser(String username) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userEntity.get().getUsername());
        userDTO.setEmail(userEntity.get().getEmail());
        userDTO.setRoles(userEntity.get().getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList()));
        return ResponseEntity.ok(userDTO);
    }
}
