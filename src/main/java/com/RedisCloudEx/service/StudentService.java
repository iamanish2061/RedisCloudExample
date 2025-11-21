package com.RedisCloudEx.service;

import com.RedisCloudEx.entity.Student;
import com.RedisCloudEx.repo.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RedisService redisService;

    public Student getStudentById(Long id){
        Student student = redisService.get(id, Student.class);
        if(student != null){
            log.info("found in redis", student);
            return student;
        }

        Optional<Student> optStudent = studentRepo.findById(id);
        Student s = optStudent.orElse(null);
        redisService.set(id, s, 600L);
        return s;
    }

}
