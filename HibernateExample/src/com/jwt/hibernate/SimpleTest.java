package com.jwt.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SimpleTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		int i = 0;

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
	
		Query query = session.createQuery("FROM Student");
		
		List list = query.list();
		
		while(i < list.size())
			i++;
		
//		while (((Student)list.get(i)).getName()!=null)
//			i++;
		
//		for(int i = 0; i < list.size(); i++) {
//			((Student)list.get(i)).getName()
//		}
			
		Student student = new Student();
		student.setId(i);
		student.setName("h");
		student.setRoll("et");
		student.setPhone("m");
		student.setDegree("me");

		Transaction tx = session.beginTransaction();
		session.save(student);
		
		session.getTransaction().rollback();
		
		query = session.createQuery("FROM Student");
		
		list = query.list();
		
		while(i < list.size())
			i++;
		
//		while (((Student)list.get(i)).getName()!=null)
//			i++;
		
//		for(int i = 0; i < list.size(); i++) {
//			((Student)list.get(i)).getName()
//		}
			
		student = new Student();
		student.setId(i+1);
		student.setName("be");
		student.setRoll("er");
		student.setPhone("rb");
		student.setDegree("öz");

		tx = session.beginTransaction();
		session.save(student);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}
}