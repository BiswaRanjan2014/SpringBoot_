 package com.dakr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.Dao.StudentDao;
import com.dakr.customexception.BussinessException;
import com.dakr.customexception.ControllerException;
import com.dakr.model.StudentRegistration;
import com.dakr.service.StudentRegisterServiceImpl;


//@RequestMapping("/students")
@RestController
public class StudentRegisterController {

	@Autowired
	private StudentRegisterServiceImpl ser;

	@Autowired
	private StudentDao stuDao;

	
	@PostMapping("/insert")
	public ResponseEntity<?> insertStud(@RequestBody StudentRegistration stu) {
		try {
			StudentRegistration s1 = ser.insertStudent(stu);
			return new ResponseEntity<StudentRegistration>(s1, HttpStatus.BAD_REQUEST);
		} catch (BussinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessege());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("610", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// Retrive Data From MYSQL
	@GetMapping("/getId/{stuId}")
	public ResponseEntity<?> getOne(@PathVariable Integer stuId) {
		try {
			StudentRegistration stu2 = ser.getStudent(stuId);
			return new ResponseEntity<StudentRegistration>(stu2, HttpStatus.BAD_REQUEST);
		} catch (BussinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessege());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("610", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/fetch")
	public Optional<StudentRegistration> fetchData(@RequestParam Integer sid) {
		return ser.fetchId(sid);

	}

	// Fetch With An Operator ::
	@GetMapping("/fetchByName/{course}")
	public List<StudentRegistration> findbycourse(@PathVariable String stuCourse) {
		return stuDao.findBystuCourseName("%" + stuCourse + "%");

	}

	// Fetch With An Student Name ::
	@GetMapping("/fetchCourseName/{name}")
	public List<StudentRegistration> fetchByName(@PathVariable String stuName) {
		return stuDao.findByStuName("%" + stuName + "%");

	}

	// Retrieve All Data From MYSQL ::
	@GetMapping("/fetchAll")
	public List<StudentRegistration> retriveAll() {
		return ser.fetchAll();
	}

	@GetMapping("/fetchall")
	public List<StudentRegistration> getAll() {
		List<StudentRegistration> s3 = ser.fetchAllStudent();
		return s3;
	}

	// for update data from database
	@PutMapping("/update")
	public StudentRegistration update(@RequestBody StudentRegistration stuReg) {
		return ser.updateStu(stuReg);
	}

	// for delete data from database
	@DeleteMapping("/delete")
	public String deleteData(@RequestParam Integer id) {
		return ser.deleteData(id);
	}

	@DeleteMapping("/deleteId/{stdId}")
	public void deleteOne(@PathVariable Integer stdId) {
		ser.deleteStudent(stdId);

	}

	@DeleteMapping("/deleteall")
	public void deleteAllStudents() {
		ser.deleteAllStudent();

	}
}
