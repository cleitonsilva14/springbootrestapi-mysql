package br.com.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springbootrestapi.entity.Student;
import br.com.springbootrestapi.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	//GET ALL STUDENTS
	//:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return repository.findAll();
	//
	}
	
	//:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable Long id) {
		Student student = repository.findById(id).get();
		return student;
	}
	
	
	//:8080/student/add
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody  Student student) {
		repository.save(student);
	}
	
	//:8080
	@PutMapping("/students/update/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updateStudent) {
		Student student = repository.findById(id).get();
		student.setName(updateStudent.getName());
		student.setPercentage(updateStudent.getPercentage());
		repository.save(student);
		return student;
	}
	
	
	@DeleteMapping("/students/delete/{id}")
	public void removeStudent(@PathVariable Long id) {
		Student student = repository.findById(id).get();
		repository.delete(student);
	}
	
	
	
	
	
	
	
}
