package com.jianguo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Text_Sms {

	private final static String APP_KEY = "6eb1ac1683e252354051958c3eae100d";
	private final static String APP_NAME = "兼果兼职";
	
	public static String textdemos(String mobile) {
		// TODO Auto-generated method stub
		String tpl_id = "2255";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
//		String code = "111111";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#code#=").append(code).append("&#hour#=").append(timeout).toString();
//		JSONObject object = null;
		try {
				tpl_values = URLEncoder.encode(tpl_values, charset);
				String url = "http://v.juhe.cn/sms/send?key=";
				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
				// 得到JSON字符串
				gets(urlAll, charset);
				// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);

		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos1(String mobile) {
		// TODO Auto-generated method stub
		String tpl_id = "14261";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append(timeout).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos2(String mobile,String name) {
		// TODO Auto-generated method stub
		String tpl_id = "14262";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos32(String mobile,String name) {
		// TODO Auto-generated method stub
		String tpl_id = "14263";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos4(String mobile,String name,String money) {
		// TODO Auto-generated method stub
		String tpl_id = "14265";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).append("&#money#=").append(money).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos6(String mobile,String name,String tel) {
		// TODO Auto-generated method stub
		String tpl_id = "15411";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).append("&#tel#=").append(tel).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	public static String textdemos5(String mobile,String job_title,String truename,String sex,String phone,String school) {
		// TODO Auto-generated method stub
		String tpl_id = "5548";
		String timeout = "20";
//		String mobile = phone;
		
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		
		String charset = "UTF-8";
		String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#job_title#=").append(job_title).append("&#truename#=").append(truename).append("&#sex#=").append(sex).append("&#phone#=").append(phone).append("&#school#=").append(school).toString();
//		JSONObject object = null;
		try {
			tpl_values = URLEncoder.encode(tpl_values, charset);
			String url = "http://v.juhe.cn/sms/send?key=";
			String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
			// 得到JSON字符串
			gets(urlAll, charset);
			// 转化为JSON类
//				object = JSONObject.fromObject(jsonResult);
			
		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
			return code;
		}
		return code;
	}
	
	/**
	 * 
	 * @param urlAll
	 *            :请求接口
	 * @param charset
	 *            :字符编码
	 * @return 返回json结果
	 */
	public static String gets(String urlAll, String charset) {
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
