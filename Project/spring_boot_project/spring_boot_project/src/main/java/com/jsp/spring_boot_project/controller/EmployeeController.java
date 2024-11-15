package com.jsp.spring_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_boot_project.dao.StudentDao;
import com.jsp.spring_boot_project.entity.Student;
import com.jsp.spring_boot_project.service.StudentService;
import com.jsp.spring_boot_project.util.ResponseStructure;

@RestController
public class EmployeeController {
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/hello")
	public void print() {
		System.out.println("Hii Everyone");
	}
	
@GetMapping("/hi")
public String printhi() {
	return "Hi Everyone";
}

//To save the data in database
//@PostMapping("/save")
//public String savestudent(@RequestBody  Student student) {
//	dao.saveStudent(student);
//	return "Student is saved";
//}


//save the data in database with message,statusCode & with all details of data
@PostMapping("/save")
public ResponseStructure<Student> saveStudent(@RequestBody  Student student){
	return service.saveStudent(student);
	
}


//To fetch the data from database by id(http://localhost:8080/delete?id=1)
@GetMapping("/student")
public Student getStudentById(@RequestParam int id){
return dao.getStudentById(id);
}

//(http://localhost:8080/get/2?)   ->(To run in url of postman)
@GetMapping("/get/{id}")
public Student getStudent(@PathVariable int id){
return dao.getStudentById(id);
}

//To delete the data from the database(http://localhost:8080/delete?id=1)
@DeleteMapping("delete")
public String deleteStudent(@RequestParam int id) {
dao.deleteStudent(id);
return "Student deleted";
}

//To update the data in database(http://localhost:8080/student?id=3)
@PutMapping("/student")
public Student updateStudent(@RequestParam int id, @RequestBody Student student){
return dao.updateStudent(id,student);
}}







