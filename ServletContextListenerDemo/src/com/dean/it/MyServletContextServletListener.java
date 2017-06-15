package com.dean.it;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextServletListener implements ServletContextListener {
	
	/**
	 * 当servelt容器启动web应用时调用该方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("******当servelt容器启动web应用时调用该方法******");
		//System.out.println("******event.getServletContext()拿到servletContext后可以做很多事情******");
		//在此处启动一个线程
		System.out.println("****此处启动一个线程***");
		MyThread myThread = new MyThread();
		new Thread(myThread).start();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("******当servlet容器停止web应用时候调用该方法*****");
	}
	

}
