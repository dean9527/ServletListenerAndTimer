package com.dean.it;

import java.util.Timer;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("*****在线程里面搞点事情比如写个定时bomb*****");
		System.out.println("*****开玩笑，最多写个定时器******");
		Timer timer = new Timer(true);
		MyTimerTask myTimerTask = new MyTimerTask();
		//定时任务在web应用启动10秒后执行
		long delay = 10*1000;
		//定时任务每隔30秒执行一次
		long period = 30*1000;
		timer.schedule(myTimerTask, delay, period);
	}

}
