package com.courses.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.courses.Model.Course;
import com.courses.repository.Repository;

@Service
public class CourseService {
	
	ArrayList<Course> arr = null;
	
	public CourseService() {
		arr = Repository.getCourseDetails();
	}
	
	
	public ArrayList<Course> getAllCourses() {
		return arr;
	}
	
	public Course getCourseById(int id) {
		for(int i = 0; i < arr.size(); i++) {
			if ( arr.get(i).getId() == id) {
				return arr.get(i);
			}
		}
		return null;
	}
	
	public boolean addCourse(Course course) {
		arr.add(course);
		return true;
	}
	
	public boolean updateCourse(Course course) {
		
		for(int i = 0; i < arr.size(); i++) {
			if(course.getId() == arr.get(i).getId()) {
				arr.set(i, course);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean deleteCourse(int id) {
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getId() == id) {
				arr.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
