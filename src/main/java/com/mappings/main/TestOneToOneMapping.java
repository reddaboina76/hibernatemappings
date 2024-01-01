package com.mappings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mappings.pojos.Passport;
import com.mappings.pojos.Student;

public class TestOneToOneMapping {
	public static void main(String[] args) {

		// save();
		read();
	}

	private static void read() {
		// single table student

		/*
		 * Session session = DBUtil.getSf().openSession(); Student stu = (Student)
		 * session.get(Student.class, 101); System.out.println();
		 */
//..........................................................
		// join on two tables student,passport

		Session session = DBUtil.getSf().openSession();
		Passport pp = (Passport) session.get(Passport.class, "BXCNXF585");

		System.out.println(pp.getPassportNum() + " " + pp.getExpireDate() + " " + pp.getLocation());
		System.out.println(pp.getStu().getStuName() + " " + pp.getStu().getBranch() + " " + pp.getStu().getClg() + " "
				+ pp.getStu().getStuId());

	}

	private static void save() {
		Student stu = new Student();

		stu.setStuName("venkatesh");
		stu.setBranch("EEE");
		stu.setClg("CGIT");

		Passport passport = new Passport();
		passport.setPassportNum("kkkkkkk77");
		passport.setLocation("SEC");
		passport.setExpireDate("2025");

		passport.setStu(stu);
		stu.setPassport(passport);

		Session session = DBUtil.getSf().openSession();
		Transaction tx = session.beginTransaction();

		session.save(passport);
		tx.commit();

		session.close();

	}
}