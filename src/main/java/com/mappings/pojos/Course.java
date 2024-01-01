package com.mappings.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	@Column(name="course_id")
	private String courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="duration")
	private String courseDuration;
	
	  @ManyToMany(cascade=CascadeType.ALL)
	  @JoinTable(name="student_course_mapping",
	  joinColumns={@JoinColumn(name="cour_id")},
	  inverseJoinColumns={@JoinColumn(name="student_id")})
	private List<InstStudent> stdList;
	
	public List<InstStudent> getStdList() {
		return stdList;
	}

	public void setStdList(List<InstStudent> stdList) {
		this.stdList = stdList;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	
}
