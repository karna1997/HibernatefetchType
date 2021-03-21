package com.jbk.userclasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;

public class Test {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Country.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Employee emp = session.get(Employee.class, 1);

		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getDeptit());
		System.out.println(emp.getStatus());
		System.out.println(emp.getCreatedBy());
		System.out.println(emp.getCreatedDtm());
		System.out.println(emp.getUpdatedBy());
		System.out.println(emp.getUpdatedDtm());
		System.out.println(emp.getCountry().getCid());
		System.out.println(emp.getCountry().getCname());
	}

		
}
