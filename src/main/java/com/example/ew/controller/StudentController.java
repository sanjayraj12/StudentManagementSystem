package com.example.ew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ew.entity.EmsEntity;
import com.example.ew.exception.ResourceNotFoundException;
import com.example.ew.model.Student;
import com.example.ew.repository.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {
	
	@Autowired
	private StudentRepository studentrepo;

	@PostMapping("/add")
	Student addStudent(@RequestBody Student student)
	{
		return studentrepo.save(student);
	}
	
	@GetMapping("/showall")
	List<Student>showAllStudents()
	{
		return studentrepo.findAll();
		
	}
	
	@GetMapping("/stud/{id}")
	public Student getById(@PathVariable long id) {
	    return studentrepo.findById(id)
	            .orElseThrow(() ->  new ResourceNotFoundException("Student"," Id", id));
	}
	
	@PutMapping("/stud/{id}")
	Student updatestud(@RequestBody Student student,@PathVariable long id) {
Student std =studentrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student"," Id", id) );
		
		std.setFirstname(student.getFirstname());
		std.setLastname(student.getLastname());
		std.setEmail(student.getEmail());
		studentrepo.save(std);
		return std;
		}	            
		
	}
