package com.jianguo.servlet.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.util.Frequently;

public class T_Text_Sms_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_Text_Sms_Servlet() {
		super();
	}
	
	private final static String APP_KEY = "6eb1ac1683e252354051958c3eae100d";
	private final static String APP_NAME = "兼果兼职";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_Text_Sms_Servlet?only=D1F4C2041C993D383D2D0447FF15DB63&phone=13614093590
	//http://192.168.1.233/JianGuo_Server/T_Text_Sms_Servlet?only=D1F4C2041C993D383D2D0447FF15DB63&phone=18631017353
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_Text_Sms_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String phone =request.getParameter("phone"); 
		
		//------------------访问限制--------开始----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		if(only.equals(ss_only)){	
		//------------------访问限制--------结束----------------------
			
			String tpl_id = "2255";
			String timeout = "20";
			String mobile = phone;
			
			long random =(long)((Math.random()*9+1)*100000);
			String code = random+"";
			
			String charset = "UTF-8";
			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#code#=").append(code).append("&#hour#=").append(timeout).toString();
//			JSONObject object = null;
			try {
					tpl_values = URLEncoder.encode(tpl_values, charset);
					String url = "http://v.juhe.cn/sms/send?key=";
					String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
					// 得到JSON字符串
					String jsonResult = get(urlAll, charset);
					// 转化为JSON类
//					object = JSONObject.fromObject(jsonResult);

			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
				params.put("message", "200");
				params.put("code", code);
				PrintWriter pw = response.getWriter();
				Gson g = new Gson();
				String str = g.toJson(params); 
				pw.write(str);
				pw.flush();
				pw.close();
			}
			params.put("message", "200");
			params.put("code", code);
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
	
	/**
	 * 
	 * @param urlAll
	 *            :请求接口
	 * @param charset
	 *            :字符编码
	 * @return 返回json结果
	 */
	public String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
