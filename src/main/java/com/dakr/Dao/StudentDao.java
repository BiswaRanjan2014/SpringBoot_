package com.dakr.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakr.model.StudentRegistration;

@Repository
public interface StudentDao extends JpaRepository<StudentRegistration, Integer> {


	public List<StudentRegistration> findBystuCourseName(String stuCourse);

	List<StudentRegistration> findByStuName(String stuName);

}
