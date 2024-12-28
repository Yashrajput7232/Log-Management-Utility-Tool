// UserDTO.java
package com.project.logmanagementutilitytool.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Data
public class UserDTO {
    private String username;
    private String email;
    private List<String> roles;

    // Getters and setters
}