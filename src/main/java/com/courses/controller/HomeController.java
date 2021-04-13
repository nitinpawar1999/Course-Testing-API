package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courses.Model.Course;
import com.courses.service.CourseService;

@RestController
public class HomeController {

	@Autowired
	public CourseService courseService;
	
	
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/courses")
	public boolean addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public boolean updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public boolean deleteCourse(@PathVariable int id) {
		return courseService.deleteCourse(id);
	}
	
}
