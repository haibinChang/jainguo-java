package com.jianguo.servlet.qiniu;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jianguo.util.MailSenderInfo;
import com.jianguo.util.SimpleMailSender;
import com.squareup.okhttp.MediaType;

public class Ceshi_Servlet extends HttpServlet {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	private static final long serialVersionUID = 1L;
	public Ceshi_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.132/JianGuo_Server/Ceshi_Servlet?only=64D78679E0E12A7875F052650905B6D3
	//http://101.200.197.237:8080/Ceshi_Servlet?only=C9B1DDF8F5CEE9C376794456D3D463E6
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---Ceshi_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String height =request.getParameter("height");
		
		//聊天系统消息
//		OkHttpClient client = new OkHttpClient();
////		String post() throws IOException {
//String sss = "{\"name\": \"Notification Channel\",\"sys\": true}";
//
//		RequestBody body = RequestBody.create(JSON, sss);
//
//		      Request requestq = new Request.Builder()
//		      .url("https://api.leancloud.cn/1.1/classes/_Conversation")
//		      .addHeader("X-LC-Id", "AtwJtfIJPKQFtti8D3gNjMmb-gzGzoHsz")
//		      .addHeader("X-LC-Key", "spNrDrtGWAXP633DkMMWT65B")
//		      .addHeader("Content-Type", "application/json")
//		      .post(body)
//		      .build();
//
//		      Response responseq = client.newCall(requestq).execute();
//		    if (responseq.isSuccessful()) {
////		        return responseq.body().string();
//		    	System.out.println(responseq.body().string());
//		    } else {
//		        throw new IOException("Unexpected code " + responseq);
//		    }
		
//		String beginDate="1328007600000";
//
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String sd = sdf.format(new Date(Long.parseLong(beginDate)));
//		System.out.println(sd);
		
//		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date beginDate = new Date();
//		Calendar date = Calendar.getInstance();
//		date.setTime(beginDate);
//		date.set(Calendar.DATE, date.get(Calendar.DATE) - 3);
//		try {
//			Date endDate = dft.parse(dft.format(date.getTime()));
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String sd = sdf.format(endDate);
//			 Date dates=sdf.parse(sd);
//			 long timeStemp = dates.getTime();
//			System.out.println("----"+sd+"----"+timeStemp);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		float scale = (float) 50.999; 
//		DecimalFormat fnum = new DecimalFormat("##0.00"); 
//		String dd=fnum.format(scale); 
//		System.out.println(dd);
		
		//http://192.168.1.132/JianGuo_Server/Ceshi_Servlet
//		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
//		String date = sdf.format(new Date(1467156600*1000L));
//		System.out.println("---"+date+"---"); 
		
//		//这个类主要是设置邮件
//		  MailSenderInfo mailInfo = new MailSenderInfo(); 
//		  mailInfo.setMailServerHost("smtp.ym.163.com"); 
//		  mailInfo.setMailServerPort("25"); 
//		  mailInfo.setValidate(true); 
//		  mailInfo.setUserName("imiu@muwood.com"); 
//		  mailInfo.setPassword("MUshi888");//您的邮箱密码 
//		  mailInfo.setFromAddress("imiu@muwood.com"); 
//		  mailInfo.setToAddress(user_username); 
//		  mailInfo.setSubject("IMIU注册验证码"); 
////		  mailInfo.setContent("IMIU验证码:"+test+"（邮箱）工作人员不会向您索要密码、验证码等信息。如非本人操作，请联系IMIU客服或忽略"); 
//		  mailInfo.setContent("IMIU："+test+""); 
//	        //这个类主要来发送邮件
//		  SimpleMailSender sms = new SimpleMailSender();
//	         sms.sendTextMail(mailInfo);//发送文体格式 
		
	}
}
