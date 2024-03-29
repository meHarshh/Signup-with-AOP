package com.jsp.signup.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.jsp.signup.model.SignUp;

@Repository
public class SignUpRepository {

	public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(SignUp.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		return session;
	}
	public void saveUser(SignUp signup) {
		Session session = SignUpRepository.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(signup);
		transaction.commit();
		session.close();
	}
}
