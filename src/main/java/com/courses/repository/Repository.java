package com.courses.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.courses.Model.Course;

public class Repository {
	
public static ArrayList<Course> courseDetails = new ArrayList<>();
	
	private static void init() {
		courseDetails.add(new Course(1, "Python", "Beginner Bootcamp for Python", "34.45", "4.5", "Rey Hayes"));
		courseDetails.add(new Course(2, "Java", "Beginner Bootcamp for Java", "84.45", "3.5", "Soma Hayes"));
		courseDetails.add(new Course(3, "Javascript", "Beginner Bootcamp for Javascript", "90.45", "4.9", "Remy Alveo"));
	}
	
	public static ArrayList<Course> getCourseDetails() {
		init();
		return courseDetails;
	}
	
	public static boolean setCourseDetails(ArrayList<Course> arr) {
		courseDetails = arr;
		return true;
	}
	
}
