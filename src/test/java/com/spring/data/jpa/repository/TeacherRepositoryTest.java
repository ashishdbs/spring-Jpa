package com.spring.data.jpa.repository;

import com.spring.data.jpa.entities.Course;
import com.spring.data.jpa.entities.Student;
import com.spring.data.jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course DBA = Course.builder()
                .tittle("DBA")
                .credit(5)
                .build();

        Course java = Course.builder()
                .tittle("java")
                .credit(6)
                .build();

        List<Course> courseList = new ArrayList<>();
        courseList.add(DBA);
        courseList.add(java);

        Teacher teacher = Teacher.builder()
                .firstName("Akash")
                .lastName("Kumar")
                .courses(courseList)
                .build();

        teacherRepository.save(teacher);
    }

}