package com.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="course_id")
	private int course_id;
	
	public Student() {}
	
	public Student (long ID, String NAME, int AGE, int COURSEID) {
		this.id = ID;
		this.name = NAME;
		this.age = AGE;
		this.course_id = COURSEID;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getCourse_id() {
		return course_id;
	}
	
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	@Override
	public String toString () {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", course_Id=" + course_id + "]";
	}
	
}