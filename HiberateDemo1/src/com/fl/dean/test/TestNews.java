package com.fl.dean.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestNews {
	
	private SessionFactory sessionFactory = null;
	
	private Session session = null;
	
	private Transaction transaction = null;
	
	@Before
	public void init() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@Test
	public void testConnection() {
		session.doWork(new Work(){
			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn);
			}});
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
