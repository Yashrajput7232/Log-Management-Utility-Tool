package com.project.logmanagementutilitytool.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Index {
    @GetMapping("/")
    public String getMethodName() {
        return new String("This is View for Index");
    }
    


}
