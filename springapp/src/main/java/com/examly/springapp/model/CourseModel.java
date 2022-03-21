package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import java.util.LinkedHashSet;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.examly.springapp.model.InstituteModel;

@Entity
@Table(name="course")
public class CourseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
    private String courseName;
	private String courseDescription;
	private String courseDuration;
	
	
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private InstituteModel institute;
	
	
	@OneToMany(mappedBy="course",cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Admission> admissions=new LinkedHashSet<>();
	
	
	
	
	
	public Set<Admission> getAdmissions() {
		return admissions;
	}
	public void setAdmissions(Set<Admission> admissions) {
		this.admissions = admissions;
	}
	public InstituteModel getInstitute() {
		return institute;
	}
	public void setInstitute(InstituteModel institute) {
		this.institute = institute;
	}
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	public CourseModel() {
		
	}
	public CourseModel(String courseName, String courseDescription, String courseDuration) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseDuration = courseDuration;
		
		
	}

	

}
