package com.project.logmanagementutilitytool.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class Index {
    @GetMapping("/")
    public String Index() {
        return new String("This is View for Index");
    }
    


}
