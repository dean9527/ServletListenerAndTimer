package com.tf.dean;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("serial")
public class HelloFreeMarkerServlet extends HttpServlet{
	
	//负责管理freemarker的实例
	private Configuration cfg = null;
	
	public void init() throws ServletException {
		//创建一个freemarker实例
		cfg = new Configuration();
		//制定freemarker模板文件的位置
		cfg.setServletContextForTemplateLoading(this.getServletContext(), "/WEB-INF/templates");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//建立数据模型
		Map<String, String> dataModel = new HashMap<String, String>();
		dataModel.put("message", "Hello FreeMarker");
		//获取模板文件
		Template t = cfg.getTemplate("test.ftl");
		//使用模板文件的charset作为本页面的charSet
		//使用text/hmtl MIME-TYPE
		resp.setContentType("text/html;charset="+t.getEncoding());

		Writer out = resp.getWriter();
		try {
			t.process(dataModel, out);//往模板里写数据
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
