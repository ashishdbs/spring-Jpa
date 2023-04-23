package com.spring.data.jpa.repository;


import com.spring.data.jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //JPQL - based on the classes that you have created not based on the data base
    @Query("select s from Student s where s.emailId =?1")
    Student getByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId =?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Native Query
    @Query(value = "select s.first_name from tbl_student s where s.email_address = ?1", nativeQuery = true)
    String getStudentFirstNameByEmailAddressNative(@Param("emailId") String emailId);

    // Native Query Param
    @Query(value = "select s.first_name from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    String getStudentFirstNameByEmailAddressNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student s set s.first_name = :firstName where s.email_address = :emailId", nativeQuery = true)
    int updateStudentFirstNameByEmailAddressNativeParam(@Param("firstName") String firstName,@Param("emailId") String emailId);


}
