package com.dean.it;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		long currentTime = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(currentTime);
		Date date = cal.getTime();
		SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = simpleFormatter.format(date);
		System.out.println(now + ":这里放你的定时任务里面的具体业务，比如扫描文件，扫描log, 定时删除。。。");
	}
}
