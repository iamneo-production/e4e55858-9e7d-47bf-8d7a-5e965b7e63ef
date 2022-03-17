package com.project.backend.SpringBootBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseModel> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseModel addCourse(@RequestBody CourseModel course) {
        return courseRepository.save(course);
    }

    public CourseModel editById(int courseId, @RequestBody CourseModel course) {
        CourseModel newcourse = courseRepository.getById(courseId);
        newcourse.setcourseName(course.getcourseName());
        newcourse.setcourseDescription(course.getcourseDescription());
        newcourse.setcourseDuration(course.getcourseDuration());
        return courseRepository.save(newcourse);
    }

    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

}
