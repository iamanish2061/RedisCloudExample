package com.RedisCloudEx.controller;

import com.RedisCloudEx.entity.Student;
import com.RedisCloudEx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-student-by-id")
    public Student getStudent(@RequestParam Long id ){
        return studentService.getStudentById(id);
    }


}
