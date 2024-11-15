package com.jsp.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.spring_boot_project.dao.StudentDao;
import com.jsp.spring_boot_project.entity.Student;
import com.jsp.spring_boot_project.util.ResponseStructure;
@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	public ResponseStructure<Student> saveStudent(Student student){
	
		 ResponseStructure<Student> responseStructure=new  ResponseStructure<Student>();

		 responseStructure.setMessage("Student Saved");

		 responseStructure.setStatusCode(HttpStatus.CREATED.value());

		 responseStructure.setData(dao.saveStudent(student));
		 
		 return  responseStructure;

	}


}
