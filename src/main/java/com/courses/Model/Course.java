package com.courses.Model;

import java.text.DecimalFormat;

public class Course {
	
	int id;
	String courseName;
	String courseDescription;
	String coursePrice;
	String rating;
	String authorName;
	
	public Course() {
		
	}
	
	public Course(int id, String courseName, String courseDescription, String coursePrice, String rating, String authorName) {
		this.id = id;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
		this.courseName = courseName;
		this.rating = rating;
		this.authorName = authorName;
	}
	
	static DecimalFormat dec = new DecimalFormat("#########.00");
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", coursePrice=" + coursePrice + ", rating=" + rating + ", authorName=" + authorName + "]";
	}
	
	
	
}
