package com.spring.data.jpa.repository;

import com.spring.data.jpa.entities.Guardian;
import com.spring.data.jpa.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void test(){
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("999999999")
                .build();

        Student student = Student.builder()
                .emailId("def@gamil.com")
                .firstName("abc")
                .lastName("xyz")
               /* .guardianName("asd")
                .guardianEmail("yrw@gmail.com")
                .guardianMobile("9999999999")*/
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findByEmailAddressTest(){
        Student student = studentRepository.getByEmailAddress("def@gamil.com");
        log.info("Student :" + student);

    }

    @Test
    public void getStudentFirstNameByEmailAddressTest(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("def@gamil.com");
        log.info("firstName :" + firstName);

    }

    @Test
    public void getStudentFirstNameByEmailAddressNativeTest(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddressNativeParam("def@gamil.com");
        log.info("firstName :" + firstName);

    }

    @Test
    public void getStudentFirstNameByEmailAddressNativeParamTest(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddressNativeParam("def@gamil.com");
        log.info("firstName :" + firstName);

    }

    @Test
    public void updateStudentFirstNameByEmailAddressNativeParamTest(){
       int number = studentRepository.updateStudentFirstNameByEmailAddressNativeParam("Nikhil","def@gamil.com");
        log.info("updated row :" + number);

    }

}