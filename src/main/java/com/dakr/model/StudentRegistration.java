package com.dakr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Stu_Register")
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stuId;
	private String stuName;
	private String stuCourse;
	private String stuAdres;
	private String stuMobNo;
	private Integer stuAge;
	private String stuGender;

}
