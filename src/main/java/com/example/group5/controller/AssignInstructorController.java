package com.example.group5.controller;

import com.example.group5.configure.SpringConfig;
import com.example.group5.model.User;
import com.example.group5.service.AssignInstructorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AssignInstructorController {
    public AssignInstructorService assignInstructorService = SpringConfig.getObject().getAssignInstructorService();

    @PostMapping("/admin/assigninstructor")
    public void assignInstructor(User user, String courseID){
        assignInstructorService.assignAsInstructor(user, courseID);
    }

    @GetMapping("/users/fectchusers")
    public List<User> getUserList(){
        return assignInstructorService.getAllUsers();
    }
}
