package com.student.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.student.demo.model.Student;

//ReadyMade Interface For CRUD operations
//public interface StudentRepository extends CrudRepository<Student, Integer>
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
