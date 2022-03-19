package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.model.Student;
import com.springboot.exception.RecordNotFoundException;
import com.springboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<Student> getAllStudent() {
		List<Student> studentList = repository.findAll();

		if (studentList.size() > 0) {
			return studentList;
		} else {
			return new ArrayList<Student>();
		}
	}

	public Student getStudentById(Long id) throws RecordNotFoundException {
		Optional<Student> student = repository.findById(id);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

	public Student createOrUpdateStudent(Student entity) throws RecordNotFoundException {
		Optional<Student> student = repository.findById(entity.getId());

		if (student.isPresent()) {
			Student newEntity = student.get();
			newEntity.setName(entity.getName());
			newEntity.setAge(entity.getAge());
			newEntity.setCourse_id(entity.getCourse_id());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteStudentById(Long id) throws RecordNotFoundException {
		Optional<Student> student = repository.findById(id);

		if (student.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No student record exist for given id");
		}
	}

}
