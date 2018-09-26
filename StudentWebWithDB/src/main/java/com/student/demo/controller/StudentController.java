package com.student.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.dao.StudentRepository;
import com.student.demo.model.Student;
@CrossOrigin
@RestController
public class StudentController
{
	//Object Injection
	@Autowired
	StudentRepository repo;
	/*@RequestMapping("/addStudent")
	public String addStudent(Student student)
	{
		System.out.println(student.toString());
		repo.save(student);
		return "home.jsp";
	}*/
	
	//Record Insertion
	@RequestMapping(path="/addStudent",consumes= {"application/json"})
	public Student addStudent(@RequestBody Student student)
	{
		System.out.println(student.toString());
		repo.save(student);
		return student;
	}
	/*@RequestMapping("/allStudents")
	@ResponseBody
	public String getAllStudent()
	{
		return repo.findAll().toString();
	}*/
	//Get all student Records from database
	@RequestMapping(path="/allStudents",produces= {"application/json"})
	@ResponseBody
	public List<Student> getAllStudent()
	{
		return repo.findAll();
	}
	
	/*@RequestMapping("/allStudents/{rollno}")
	@ResponseBody
	public String getSearchStudent(@PathVariable("rollno") int rollno)
	{
		return repo.findById(rollno).toString();
	}*/
	//Find out particular record based upon rollno
	@RequestMapping(path="/allStudents/{rollno}",produces= {"application/json"})
	@ResponseBody
	public Optional<Student> getSearchStudent(@PathVariable("rollno") int rollno)
	{
		return repo.findById(rollno);
	}
	//Delete Record From Database
	@DeleteMapping(path="/deleteStudent/{rollno}")
	public String deleteStudent(@PathVariable("rollno") int rollno)
	{
		Student student=repo.getOne(rollno);
		repo.delete(student);
		return "DELETED";
	}
	//Update Student Information
	@PutMapping(path="/updateStudent",consumes= {"application/json"})
	public Student updateStudent(@RequestBody Student student)
	{
		System.out.println(student.toString());
		repo.save(student);
		return student;
	}
}
