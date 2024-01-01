package com.mappings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mappings.pojos.Employee;
import com.mappings.pojos.Passport;
import com.mappings.pojos.Ppassport;

public class EmpPassportOneToOneMapping {

	public static void main(String[] args) {
		
	
	Employee emp = new Employee();
	emp.setEmpId(100);
	emp.setEmpName("Raju");
	emp.setCompany("TCS");
	emp.setSal("90k");
	emp.setDesignation("SE");
	
	Ppassport ppassport=new Ppassport();
	
	ppassport.setPassportNum("svsvasv568");
	ppassport.setExpireDate("2030");
	ppassport.setLocation("Ameerpet");
	
	emp.setPpassport(ppassport);
	
	SessionFactory sf = DBUtil.getSf();
	Session session = sf.openSession();
	
	session.save(emp);
	
	session.beginTransaction().commit();
	session.close();

		/*
		 * System.out.println(emp.getEmpId()); System.out.println(emp.getEmpName());
		 * System.out.println(emp.getSal()); System.out.println(emp.getDesignation());
		 * 
		 * System.out.println(emp.getCompany());
		 * 
		 * System.out.println(emp.getPassport().getPassportNum());
		 * System.out.println(emp.getPassport().getPassportNum());
		 * System.out.println(emp.getPassport().getExpireDate());
		 * System.out.println(emp.getPassport().getLocation());
		 */
	


}
}