package com.jsp.spring_boot_project.dao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.spring_boot_project.entity.Student;
import com.jsp.spring_boot_project.repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;
	
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	
	
//----------------------------------------CRUD N SAVE OPERATION--------------------------------------------------------------------------------
	//To save the data in database

//	public void saveStudent(Student student) {
//		repo.save(student);
//	}
	
	
	//To fetch the data from databse by id
	public Student getStudentById(int id){
		Optional<Student>op=repo.findById(id);
		if(op.isPresent()){
		return op.get();
		}else{
		return null;
		}}
	
//To delete the data from the database	
	public void deleteStudent(int id){
		repo.delete(getStudentById(id));
		}
	
	//To update data in database
	public Student updateStudent(int id,Student updatedstudent){
		Optional<Student>op=repo.findById(id);
		if(op.isPresent()){
		  updatedstudent.setId(id);
		return repo.save(updatedstudent);
		}
		return null;
		}
	
}



	


