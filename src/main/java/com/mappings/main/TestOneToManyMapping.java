package com.mappings.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mappings.pojos.College;
import com.mappings.pojos.University;

public class TestOneToManyMapping {

	public static void main(String[] args) {

		//save();
		read();
	}

	private static void read() {
		Session session = DBUtil.getSf().openSession();
		College c=(College) session.get(College.class, 7712);
		System.out.println(c.getClgName()+" "+c.getClgLocation());
		System.out.println(c.getUni().getUniName()+" "+c.getUni().getUniLocation());
		
		/*
		 * University uv = (University) session.get(University.class, 100);
		 * 
		 * System.out.println(uv.getUniName()+" "+uv.getUniLocation()); List<College>
		 * clgList = uv.getClgList(); for (College college : clgList) {
		 * System.out.println(college.getClgName()+" "+college.getClgLocation());
		 */
		}
		
	

	private static void save() {
		Session session = DBUtil.getSf().openSession();
		
		University uv = new University();
		uv.setUniId(101);
		uv.setUniName("OU");
		uv.setUniLocation("TARNAKA");
		
		College c1 = new College();
		c1.setClgName("CBIT");
		c1.setClgLocation("GANDIPET");
		c1.setEstablished("1999");
		c1.setUni(uv);
		
		College c2 = new College();
		c2.setClgName("VASAVI");
		c2.setClgLocation("LANGERHOUSE");
		c2.setEstablished("1950");
		c2.setUni(uv);
		
		College c3 = new College();
		c3.setClgName("MVSR");
		c3.setClgLocation("RR");
		c3.setEstablished("1995");
		c3.setUni(uv);

		List<College> list = new ArrayList<College>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		uv.setClgList(list);

		Transaction tx = session.beginTransaction();
		session.save(c1);
		session.save(c2);
		session.save(c3);

		tx.commit();
		session.close();
	}

	
}
