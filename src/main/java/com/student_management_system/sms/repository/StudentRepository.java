package com.student_management_system.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_management_system.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
