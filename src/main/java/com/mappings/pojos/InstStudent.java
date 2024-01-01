package com.mappings.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class InstStudent {

	@Id
	@GeneratedValue
	@Column(name="st_id")
	private Integer studentId;

	@Column(name="st_name")
	private String studentName;
	
	@Column(name="st_branch")
	private String branch;
	
	
	  @ManyToMany(cascade=CascadeType.ALL)//,fetch=FetchType.EAGER
	  @JoinTable(name="student_course_mapping",
	  joinColumns={@JoinColumn(name="student_id")},
	  inverseJoinColumns={@JoinColumn(name="cour_id")})
	  private List<Course> courseList;  
	  //private List<Course> courseList = new ArrayList<Course>();
	  
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	
}
