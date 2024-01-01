package com.mappings.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mappings.pojos.Course;
import com.mappings.pojos.InstStudent;

public class TestMany {
	public static void main(String[] args) {
		save();
	}

	private static void save() {


		Session session = DBUtil.getSf().openSession();
		
		InstStudent s1=new InstStudent();
		s1.setStudentId(101);
		s1.setStudentName("Srinivas");
		s1.setBranch("MCA");
		
		InstStudent s2=new InstStudent();
		s2.setStudentId(102);
		s2.setStudentName("Charan");
		s2.setBranch("MCA");
		
		InstStudent s3=new InstStudent();
		s3.setStudentId(104);
		s3.setStudentName("Sudeer");
		s3.setBranch("CEC");
		
		Course c1 = new Course();
		c1.setCourseName("Core java");
		c1.setCourseDuration("3Months");
		
		Course c2 = new Course();
		c2.setCourseName("Hibernate");
		c2.setCourseDuration("1Month");
		
		Course c3 = new Course();
		c3.setCourseName("Sping");
		c3.setCourseDuration("45Days");
		
		List<InstStudent> list1 = new ArrayList<InstStudent>();
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		
	
	}

}
