package com.project.backend.SpringBootBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class CourseAdminController {

	@Autowired
	private CourseService courseService;

	// get all courses
	@GetMapping("/viewCourse")
	public List<CourseModel> getAllCourses() {
		return courseService.getAllCourses();
	}

	// create course rest api
	@PostMapping("/addCourse")
	public CourseModel addCourse(@RequestBody CourseModel course) {
		return courseService.addCourse(course);
	}

	// edit courses

	@PostMapping("/editCourse")
	public CourseModel editCourse(@RequestBody CourseModel course) {
		return courseService.addCourse(course);
	}

	// delete courses

	@PutMapping("/editById")
	public CourseModel editCourseById(@RequestParam("id") int courseId, @RequestBody CourseModel course) {
		return courseService.editById(courseId, course);
	}

	@DeleteMapping("/deleteCourse")
	public void deleteCourse(@RequestParam("id") int courseId) {
		courseService.deleteCourse(courseId);
	}

}
