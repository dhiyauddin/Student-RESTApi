package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.exception.RecordNotFoundException;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/Students")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = service.getAllStudent();

		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Student entity = service.getStudentById(id);

		return new ResponseEntity<Student>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> createOrUpdateStudent(Student students) throws RecordNotFoundException {
		Student updated = service.createOrUpdateStudent(students);
		return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteStudentById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}

	
}
