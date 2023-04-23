package com.spring.data.jpa.repository;

import com.spring.data.jpa.entities.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void CourseRepositoryTest(){
        List<Course> courses = courseRepository.findAll();
        log.info("courses = " + courses);
    }

}