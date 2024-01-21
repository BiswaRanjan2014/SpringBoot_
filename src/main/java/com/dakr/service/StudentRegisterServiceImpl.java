package com.dakr.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.Dao.StudentDao;
import com.dakr.customexception.BussinessException;
import com.dakr.model.StudentRegistration;

@Service
public class StudentRegisterServiceImpl implements StudentRegisterService {

	@Autowired
	private StudentDao dao;

	@Override
	public StudentRegistration insertStudent(StudentRegistration stuReg) {
		if (stuReg.getStuName().isEmpty() || stuReg.getStuName().length() == 0) {
			throw new BussinessException("601", "Plz Send Proper Name In Blanks");
		}
		try {
			StudentRegistration stu1 = dao.save(stuReg);
			return stu1;
		} catch (IllegalArgumentException e) {
			throw new BussinessException("602", "Given Student Register Details Is Null" + e.getMessage());

		} catch (Exception e) {
			throw new BussinessException("603", "Something Gone Wrong In Service Layer" + e.getMessage());

		}
	}

	@Override
	public StudentRegistration getStudent(Integer stdId) {
		try {
			return dao.findById(stdId).get();
		} catch (IllegalArgumentException e) {
			throw new BussinessException("611", "Given Student_Id  Is Null, Plz Enter Student_Id" + e.getMessage());

		} catch (NoSuchElementException e) {
			throw new BussinessException("612", "Given Student_Id Is Not Available In Database" + e.getMessage());

		}
	}

	@Override
	public Optional<StudentRegistration> fetchId(Integer sid) {
		try {
			return dao.findById(sid);
		} catch (IllegalArgumentException e) {
			throw new BussinessException("604", "Given Student_Id  Is Null, Plz Enter a Given Id" + e.getMessage());

		} catch (NoSuchElementException e) {
			throw new BussinessException("605", "Given Student_Id Is Not Available In Database" + e.getMessage());

		}

	}

	@Override
	public List<StudentRegistration> fetchAll() {
		List<StudentRegistration> stuId = null;
		try {
			stuId = dao.findAll();
		} catch (Exception e) {
			throw new BussinessException("607",
					"Something Went In Service Layer While Fetching The Data" + e.getMessage());

		}
		if (stuId.isEmpty())
			throw new BussinessException("606", "Hey List is Completely Empty , We Have Nothing To Return");
		return stuId;

	}

	@Override
	public List<StudentRegistration> fetchAllStudent() {

		return dao.findAll();
	}

	@Override
	public StudentRegistration updateStu(StudentRegistration reg) {
		return dao.save(reg);
	}

	@Override
	public void deleteStudent(Integer stuId) {
		try {
			dao.deleteById(stuId);
		} catch (IllegalArgumentException e) {
			throw new BussinessException("608", "Given Student_Id  Is Null, Plz Enter a Given Id" + e.getMessage());

		}

	}

	@Override
	public String deleteData(Integer sid) {
		String temp = "";
		if (dao.findById(sid).isPresent()) {
			dao.deleteById(sid);
			temp = "deleted successfully....";
		} else {
			temp = sid + "is not present in the Data Base";
		}
		return temp;
	}

	@Override
	public void deleteAllStudent() {
		dao.deleteAll();

	}

}
