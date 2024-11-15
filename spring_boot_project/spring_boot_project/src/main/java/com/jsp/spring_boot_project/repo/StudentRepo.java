package com.jsp.spring_boot_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring_boot_project.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
