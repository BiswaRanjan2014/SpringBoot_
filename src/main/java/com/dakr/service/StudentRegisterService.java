package com.dakr.service;

import java.util.List;
import java.util.Optional;

import com.dakr.model.StudentRegistration;

public interface StudentRegisterService {

	StudentRegistration insertStudent(StudentRegistration stuReg);

	public StudentRegistration getStudent(Integer stuId);

	public Optional<StudentRegistration> fetchId(Integer sid);
	
	public List<StudentRegistration> fetchAll();

	public List<StudentRegistration> fetchAllStudent();

	public StudentRegistration updateStu(StudentRegistration stuReg);

	public void deleteStudent(Integer stuId);

	public String deleteData(Integer sid);
	
	public void deleteAllStudent();

}
