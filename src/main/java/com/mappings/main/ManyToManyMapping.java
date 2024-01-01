package com.mappings.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mappings.pojos.Course;
import com.mappings.pojos.InstStudent;

public class ManyToManyMapping {

	public static void main(String[] args) {

		//save();
		read();
		//delete();
	}

	private static void delete() {
		Session session = DBUtil.getSf().openSession();
		//1.1Transaction tx=session.beginTransaction();
		Query q = session.createQuery("delete from Course");
		q.executeUpdate();
		//1.2tx.commit();
		session.beginTransaction().commit();//2.1
	}

	private static void read() {
		Session session = DBUtil.getSf().openSession();
		
		List<Course> listCourse = session.createQuery("from Course").list();
		for (Course course : listCourse) {
			System.out.println(course.getCourseName()+" "+course.getCourseDuration());
			
			List<InstStudent> stdList = course.getStdList();
			for (InstStudent student : stdList) {
				System.out.println(student.getStudentName()+" "+student.getBranch());
			}
		}
		
		/*
		 * //based on InstStudent to hit db.. List<InstStudent> list =
		 * session.createQuery("from InstStudent").list(); for (InstStudent instStudent
		 * : list) {
		 * System.out.println(instStudent.getStudentName()+" "+instStudent.getBranch());
		 * List<Course> courseList = instStudent.getCourseList(); for (Course course :
		 * courseList) {
		 * System.out.println(course.getCourseName()+" "+course.getCourseDuration()); }
		 */
		}


	private static void save() {
		Session session = DBUtil.getSf().openSession();

		InstStudent s1 = new InstStudent();
		//s1.setStudentId(700);
		s1.setStudentName("VENKY");
		s1.setBranch("MCA");

		InstStudent s2 = new InstStudent();
		//s2.setStudentId(701);
		s2.setStudentName("CHIRU");
		s2.setBranch("MCA");

		InstStudent s3 = new InstStudent();
		//s3.setStudentId(703);
		s3.setStudentName("NAG");
		s3.setBranch("EEE");

		Course c1 = new Course();
		c1.setCourseName("Core java");
		c1.setCourseDuration("3Months");

		Course c2 = new Course();
		c2.setCourseName("Hibenate");
		c2.setCourseDuration("1Month");

		Course c3 = new Course();
		c3.setCourseName("Spring");
		c3.setCourseDuration("45Days");
		
		//based on course to save method to db..
		List<InstStudent> list1 = new ArrayList<InstStudent>();
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		
		List<InstStudent> list2 = new ArrayList<InstStudent>();
		list2.add(s1);
		list2.add(s2);
		

		List<InstStudent> list3 = new ArrayList<InstStudent>();
		list3.add(s1);
		list3.add(s3);
		c1.setStdList(list1);
		c2.setStdList(list2);
		c3.setStdList(list3);

		
		
			
		/*
		 * //1...based on studet to save on db..this is one way.. List<Course> list1 =
		 * new ArrayList<Course>(); list1.add(c1); list1.add(c2); list1.add(c3);
		 * 
		 * List<Course> list2 = new ArrayList<Course>(); list2.add(c1); list2.add(c2);
		 * 
		 * List<Course> list3 = new ArrayList<Course>(); list3.add(c1); list3.add(c3);
		 * 
		 * s1.setCourseList(list1); s2.setCourseList(list2); s3.setCourseList(list3);
		 */
				/*
		 * 2...save on db..this is one way.. List<Course> list1 = new
		 * ArrayList<Course>(); list1.add(c1); list1.add(c2); list1.add(c3);
		 * 
		 * s1.setCourseList(list1); list1.remove(c2); s2.setCourseList(list1);
		 * list1.add(c3); list1.remove(c2); s3.setCourseList(list1);
		 */
		  
			/*
			 * 3...save on db..this is one way..
			 * instStudent..write on object..//private List<Course> courseList = new ArrayList<Course>();
			 * s1.getCourseList().add(c1); s1.getCourseList().add(c2);
			 * s1.getCourseList().add(c3);
			 * 
			 * s1.getCourseList().add(c1); s1.getCourseList().add(c2);
			 * 
			 * s1.getCourseList().add(c1); s1.getCourseList().add(c3);
			 */

		Transaction tx = session.beginTransaction();
		session.save(c1);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();

	}

}
