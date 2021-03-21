package com.jbk.userclasses;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Country;
import com.jbk.entity.Employee;

@SuppressWarnings("deprecation")
public class DeleteDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Country.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query<?> query = session.createQuery("delete From Employee where id=:"
				+ "id");
		query.setParameter("id", 17);
		int i=query.executeUpdate();
		tx.commit();
		if(i>0){
			System.out.println("Record Deleted Successfully....!!!!!");
		}
	}

}
