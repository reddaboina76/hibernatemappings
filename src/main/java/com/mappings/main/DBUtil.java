package com.mappings.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DBUtil {

	public static SessionFactory getSf() {
		return new Configuration().configure().buildSessionFactory();
	}
}
