package com.example.ew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ew.model.Student;
import com.example.ew.repository.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3003")
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
}
