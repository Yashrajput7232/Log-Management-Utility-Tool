package com.project.logmanagementutilitytool.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Roles")
@Getter
@Setter
public class RoleEntity {
    @Id
    private  String id;
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



    public RoleEntity(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
