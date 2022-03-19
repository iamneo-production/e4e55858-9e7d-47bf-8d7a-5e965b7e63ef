package com.project.backend.SpringBootBackend;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class CourseModel {
	
	@Id
	private int courseId;
	
	private String courseName;
	
	private String courseDescription;
	
	private int courseDuration;
	
	public int getcourseId() {
		return courseId;
	}
	public void setcourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getcourseName() {
		return courseName;
	}
	public  void setcourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getcourseDescription() {
		return courseDescription;
	}
	public  void setcourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getcourseDuration() {
		return courseDuration;
	}
	public void setcourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
}
/*Automatic id generation
 * // @GeneratedValue(strategy =GenerationType.SEQUENCE)
	// @GeneratedValue(strategy=GenerationType.AUTO)
 * 
 * 
 */ 

	