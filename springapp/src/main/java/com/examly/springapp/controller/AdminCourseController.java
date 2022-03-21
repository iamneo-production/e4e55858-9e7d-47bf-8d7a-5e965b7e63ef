package com.examly.springapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.dtoclass.ResponseDto;
import com.examly.springapp.model.CourseModel;
import com.examly.springapp.model.InstituteModel;
import com.examly.springapp.repository.CourseRepository;

@RestController
@CrossOrigin(origins="*")
public class AdminCourseController {
	
	@Autowired
	private CourseRepository repo;
	
	@GetMapping("/getcourses")
	public ResponseEntity<List<CourseModel>> viewInstitute() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping("/addcourse")
	public ResponseEntity<CourseModel> addCourse(@RequestBody CourseModel course) {
		return ResponseEntity.ok(repo.save(course));
	}
	@PostMapping("/updatecourse")
	public ResponseEntity<CourseModel> updateCourse(@RequestBody CourseModel course) {
		return ResponseEntity.ok(repo.save(course));
	}
	
	@GetMapping("/getcourse/{courseid}")
	public ResponseEntity<CourseModel> getCourse(@PathVariable("courseid") int courseid) {
		return ResponseEntity.ok(repo.findById(courseid).get());
	}
	
	//get courses using instituteId
	 @GetMapping("/getcourses/instituteid/{instituteid}")
		public ResponseEntity<Set<CourseModel>> getCourses(@PathVariable("instituteid") int instituteid) {
		 Set<CourseModel> course=repo.findCourses(instituteid);
		 
			return ResponseEntity.ok(course);
		}
	
	 
	
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<Object> deleteCourse(@PathVariable("courseId") int courseId) {
		
		
		repo.deleteById(courseId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto("course deleted"));
	}

}
