package com.spring.data.jpa.repository;

import com.spring.data.jpa.entities.Course;
import com.spring.data.jpa.entities.CourseMaterial;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void CourseMaterialRepositoryTest(){

        Course course = Course.builder()
                .credit(4)
                .tittle("DB")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.bookRead.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void findAllCourse(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        log.info("courseMaterials:" + courseMaterials);
    }

}