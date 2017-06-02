package com.fl.dean.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fl.dean.News;

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
	
	@Test
	public void testSaveNews(){
		for(int i=1; i<=3; i++){
			session.save(new News(i, "save news test"+i, "save news test"+i));
		}
	}
	
	@Test
	public void testDeleteNews(){
		int newsId = 9;
		News news = new News();
		news.setNewsId(newsId);
		session.delete(news);
	}

	@Test
	public void testQueryNews(){
		String hql = "from News";
		List<News> newsList = session.createQuery(hql).list();
		System.out.println("\n========print all news in db=========");
		for(News news : newsList){
			System.out.println(news.getNewsId()+","+news.getTitle()+","+news.getContent());
		}
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
