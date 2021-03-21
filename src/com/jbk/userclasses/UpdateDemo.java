package com.jbk.userclasses;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;

@SuppressWarnings("deprecation")
public class UpdateDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Country.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query<?> query = session.createQuery(
				"update Employee  set name=:name,phoneno=:phoneno,deptit=:deptit,status=:status,updatedDTm=:updatedDTm,updatedBy=:updatedBy ,country=:country  where id=:id");

		Country country = session.get(Country.class, 7);
		System.out.println(country.getCname());
		query.setParameter("name", "Rupali");
		query.setParameter("phoneno", "14523641");
		query.setParameter("deptit", "sales");
		query.setParameter("status", "Active");
		Date date = new Date(System.currentTimeMillis());
		query.setParameter("updatedDTm", date);
		query.setParameter("updatedBy", "karna");
		query.setParameter("country", country);
		query.setParameter("id", 16);
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			System.out.println("Record Updated Successfully");
		}

	}

}
