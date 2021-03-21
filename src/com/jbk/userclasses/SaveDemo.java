package com.jbk.userclasses;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;

public class SaveDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Country.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Country country = session.get(Country.class, 1);
		Employee emp = new Employee();
		emp.setName("Ruchira");
		emp.setPhoneno("123456");
		emp.setDeptit("IT");
		emp.setStatus("Active");

		Date date = new Date(System.currentTimeMillis());

		emp.setCreatedBy("karna");
		emp.setCreatedDtm(date);
		emp.setUpdatedBy("vishakha");
		emp.setUpdatedDtm(date);
		emp.setCountry(country);
		session.save(emp);
		transaction.commit();
		System.out.println("Record Saved Successfully....!!!!");
	}

}
