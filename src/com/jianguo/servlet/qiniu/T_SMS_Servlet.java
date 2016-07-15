package com.jianguo.servlet.qiniu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.sql.T_tel_code_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Text_Sms;

public class T_SMS_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_SMS_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_SMS_Servlet?only=
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_SMS_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String tel =request.getParameter("tel");
		
		//------------------访问限制--------开始----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){	
		//------------------访问限制--------结束----------------------

			String code = Text_Sms.textdemos(tel);
			
			if(!tel.equals("13614093590")){
			
			if(T_tel_code_Sql.check_tel(tel)){
				T_tel_code_Sql.update_tel(code, tel);
			}else{
				T_tel_code_Sql.insert(tel, code);
			}
			}
			params.put("message", "成功");
			params.put("code", "200");
//			params.put("text", code);
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		//------------------访问限制--------开始----------------------
		}else{
			params.put("message", "无效访问");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		}
		//------------------访问限制--------结束----------------------
	}
}
