package com.examly.springapp.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.examly.springapp.model.Admission;
@Entity
public class Student {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private Date studentDOB;
	private String studentGender;
	private String address; 
	private String mobile; 
	private int sslc;
	private int hsc; 
	private int diploma;
	
	
	
	@OneToOne(mappedBy="student",fetch=FetchType.LAZY,orphanRemoval=true)
	@JsonIgnore
	private Admission admission;
	
	
	
	
	
	
	
	
	
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	
	public Student() {
		
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public int getSslc() {
		return sslc;
	}
	public void setSslc(int sslc) {
		this.sslc = sslc;
	}
	public int getHsc() {
		return hsc;
	}
	public void setHsc(int hsc) {
		this.hsc = hsc;
	}
	public int getDiploma() {
		return diploma;
	}
	public void setDiploma(int diploma) {
		this.diploma = diploma;
	}
	public Student(String studentName, Date studentDOB, String studentGender, String address, String mobile, int sslc,
			int hsc, int diploma, Admission admission) {
		super();
		this.studentName = studentName;
		this.studentDOB = studentDOB;
		this.studentGender = studentGender;
		this.address = address;
		this.mobile = mobile;
		this.sslc = sslc;
		this.hsc = hsc;
		this.diploma = diploma;
		this.admission = admission;
	}
	
	
	
}
