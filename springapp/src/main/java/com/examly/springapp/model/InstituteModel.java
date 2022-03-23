package com.examly.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.examly.springapp.model.CourseModel;

@Entity
@Table(name = "Institute")
public class InstituteModel {
	
	@Id
	@Column(name="iid")
	private Integer instituteId;
	
	@Column(name = "iname")
	private String instituteName;
	@Column(name="idesc")
	private String instituteDescription;
	@Column(name="iaddress")
	private String instituteAddress;
	@Column(name="imobile")
	private String mobile;
	@Column(name="iemail")
	private String email;
	
	@OneToMany(mappedBy="institute",cascade=CascadeType.ALL)
	@JsonIgnore
	@Column(name="iid")
	private Set<CourseModel> courses=new LinkedHashSet<>();
	
	
//	@OneToMany(mappedBy="institut",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
//	@JsonIgnore
//	private Set<Admission> admissions=new LinkedHashSet<>();
	
	public Set<CourseModel> getCourses() {
		return courses;
	}
	public void setCourses(Set<CourseModel> courses) {
		this.courses = courses;
	}
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInstituteDescription() {
		return instituteDescription;
	}
	public void setInstituteDescription(String instituteDescription) {
		this.instituteDescription = instituteDescription;
	}
	public String getInstituteAddress() {
		return instituteAddress;
	}
	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
