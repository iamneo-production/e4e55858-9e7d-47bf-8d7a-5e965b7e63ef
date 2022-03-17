package com.project.backend.SpringBootBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class CourseUserController {

	@Autowired
	private CourseService courseService;

	// get all courses
	@GetMapping("/viewCourse")
	public List<CourseModel> getAllCourses() {
		return courseService.getAllCourses();
	}

	

}
