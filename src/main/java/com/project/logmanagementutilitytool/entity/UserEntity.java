package com.project.logmanagementutilitytool.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import  javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "Users")
public class UserEntity {
    @Id
    private String id ;
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Password must be alphanumeric")
    private String password;
    private String email;

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    private Set<RoleEntity> roles =new HashSet<>();

    public UserEntity(String id, String username, String password, String email, Set<RoleEntity> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
