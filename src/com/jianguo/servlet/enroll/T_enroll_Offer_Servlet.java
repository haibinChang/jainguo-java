package com.jianguo.servlet.enroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.bean.T_job_info_Bean;
import com.jianguo.bean.T_merchant_Bean;
import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.sql.T_enroll_Sql;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.sql.T_job_info_Sql;
import com.jianguo.sql.T_job_record_Sql;
import com.jianguo.sql.T_merchant_Sql;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpush_shang;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpushcc_shang;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Jdpusher_shang;
import com.jianguo.util.Text_Sms;

public class T_enroll_Offer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_enroll_Offer_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_enroll_Offer_Servlet?only=648C6D6926E835F494A0878DBB0CFB90&login_id=2&job_id=1万&Offer=1
	//http://101.200.205.243:8080/T_enroll_Offer_Servlet?only=66490E4B49BCED237AC52B190F541FBC&login_id=67&job_id=2&offer=1
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_enroll_Offer_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();
		
		String login_id =request.getParameter("login_id");
		String job_id =request.getParameter("job_id");
		String Offer =request.getParameter("offer");
		
		//------------------访问限制--------开始----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------访问限制--------结束----------------------
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ly_time = sdf.format(new java.util.Date());
			
			if(T_enroll_Sql.check_login_id_job_id(login_id, job_id)){
				if(Offer.equals("1")){
					int i = T_enroll_Sql.update_status("1",login_id, job_id);
					if(i == 1){
						T_job_Sql.update_user_count_jian(job_id);
						
						Jdpush.sendPush("工作成功取消，多次取消会影响您的信用等级","jianguo"+login_id);
						Jdpusher.sendPush("工作成功取消，多次取消会影响您的信用等级","jianguo"+login_id);
						Jdpushcc.sendPush("工作成功取消，多次取消会影响您的信用等级","jianguo"+login_id);
						
						T_job_Bean t_job11 = T_job_Sql.select_id(job_id);
						T_push_Sql.insert(login_id, t_job11.getName(), "取消报名", "工作成功取消，多次取消会影响您的信用等级", "0", ly_time);
						
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush.sendPush("有人取消报名【"+t_job.getName()+"】请查看","jianguo"+t_merchant.getLogin_id());
						Jdpusher.sendPush("有人取消报名【"+t_job.getName()+"】请查看","jianguo"+t_merchant.getLogin_id());
						Jdpushcc.sendPush("有人取消报名【"+t_job.getName()+"】请查看","jianguo"+t_merchant.getLogin_id());
						
						params.put("message", "用户取消成功");
//					}else{
//					params.put("message", "用户取消失败");
					}
				}else if(Offer.equals("2")){
						T_enroll_Sql.update_status("2",login_id, job_id);
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
						Text_Sms.textdemos32(t_user_login.getTel(),t_job.getName());
						
						Jdpush.sendPush("您所报【"+t_job.getName()+"】被商家拒绝了，请浏览其他兼职","jianguo"+login_id);
						Jdpusher.sendPush("您所报【"+t_job.getName()+"】被商家拒绝了，请浏览其他兼职","jianguo"+login_id);
						Jdpushcc.sendPush("您所报【"+t_job.getName()+"】被商家拒绝了，请浏览其他兼职","jianguo"+login_id);
						
//						T_job_Bean t_job11 = T_job_Sql.select_id(job_id);
						T_push_Sql.insert(login_id, t_job.getName(), "报名被拒", "您所报【"+t_job.getName()+"】被商家拒绝了，请浏览其他兼职", "0", ly_time);
						
						params.put("message", "商家取消录取成功");
				}else if(Offer.equals("3")){
					int i = T_enroll_Sql.update_status("5",login_id, job_id);
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_job_Sql.update_count(job_id);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
						Text_Sms.textdemos2(t_user_login.getTel(),t_job.getName());
						
//						Jdpush.sendPush("您所报【"+t_job.getName()+"】已被商家正式录用，请确认参加","jianguo"+login_id);
//						Jdpusher.sendPush("您所报【"+t_job.getName()+"】已被商家正式录用，请确认参加","jianguo"+login_id);
//						Jdpushcc.sendPush("您所报【"+t_job.getName()+"】已被商家正式录用，请确认参加","jianguo"+login_id);
						
						Jdpush_shang.sendPush("商家成功录取【"+t_job.getName()+"】","jianguo"+login_id);
						Jdpusher_shang.sendPush("商家成功录取【"+t_job.getName()+"】","jianguo"+login_id);
						Jdpushcc_shang.sendPush("商家成功录取【"+t_job.getName()+"】","jianguo"+login_id);
						
						T_push_Sql.insert(login_id, t_job.getName(), "录用", "您所报【"+t_job.getName()+"】已被商家正式录用，请确认参加", "0", ly_time);
						
						params.put("message", "商家录取成功");
				}else if(Offer.equals("4")){
					int i = T_enroll_Sql.update_status("4",login_id, job_id);
					if(i == 1){
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush_shang.sendPush("用户取消参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						Jdpusher_shang.sendPush("用户取消参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						Jdpushcc_shang.sendPush("用户取消参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						
						T_job_Bean t = T_job_Sql.select_id(job_id);
						if(t.getCount() == 0){
						}else{
							T_job_Sql.update_count_jian(job_id);
						}
						T_job_record_Sql.update_cancel(login_id);
						
						params.put("message", "用户取消参加成功");
					}else{
					params.put("message", "用户取消参加失败");
					}
				}else if(Offer.equals("5")){
					int i = T_enroll_Sql.update_status("5",login_id, job_id);
					if(i == 1){
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_job_info_Bean t_job_info = T_job_info_Sql.select_job_id(job_id);
						
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush_shang.sendPush("用户确认参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						Jdpusher_shang.sendPush("用户确认参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						Jdpushcc_shang.sendPush("用户确认参加【"+t_job.getName()+"】","jianguo"+t_merchant.getLogin_id());
						
						T_push_Sql.insert(login_id, t_job.getName(), "确认参加", "用户确认参加【"+t_job.getName()+"】", "0", ly_time);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
						Text_Sms.textdemos6(t_user_login.getTel(),t_job.getName(),t_job_info.getTel());
						
						params.put("message", "用户确认参加成功");
					}else{
					params.put("message", "用户确认参加失败");
					}
				}else if(Offer.equals("6")){
					int i = T_enroll_Sql.update_status("6",login_id, job_id);
					if(i == 1){
						T_job_Sql.update_count_jian(job_id);
						params.put("message", "用户取消参加成功");
					}else{
					params.put("message", "用户取消参加失败");
					}
				}else if(Offer.equals("7")){
					int i = T_enroll_Sql.update_status("7",login_id, job_id);
					if(i == 1){
						T_job_Bean t = T_job_Sql.select_id(job_id);
						if(t.getCount() == 0){
						}else{
							T_job_Sql.update_count_jian(job_id);
						}
						params.put("message", "商家取消录取成功");
					}else{
					params.put("message", "商家取消录取失败");
					}
				}else if(Offer.equals("8")){
					int i = T_enroll_Sql.update_status("8",login_id, job_id);
					if(i == 1){
						params.put("message", "到工作时间成功");
					}else{
					params.put("message", "到工作时间失败");
					}
				}else if(Offer.equals("9")){
					int i = T_enroll_Sql.update_status("9",login_id, job_id);
					
					if(i == 1){
						params.put("message", "商家点击结束成功");
					}else{
					params.put("message", "商家点击结束失败");
					}
				}else if(Offer.equals("10")){
					int i = T_enroll_Sql.update_status("10",login_id, job_id);
					if(i == 1){
						params.put("message", "用户催工资成功");
					}else{
					params.put("message", "用户催工资失败");
					}
				}else if(Offer.equals("11")){
					int i = T_enroll_Sql.update_status("11",login_id, job_id);
					if(i == 1){
						params.put("message", "商家结算成功");
					}else{
					params.put("message", "商家结算失败");
					}
				}else if(Offer.equals("12")){
					int i = T_enroll_Sql.update_status("12",login_id, job_id);
					if(i == 1){
						params.put("message", "商家评价成功");
					}else{
					params.put("message", "商家评价失败");
					}
				}else if(Offer.equals("13")){
					int i = T_enroll_Sql.update_status("13",login_id, job_id);
					
					if(i == 1){
						params.put("message", "商家评价成功");
					}else{
					params.put("message", "商家评价失败");
					}
				}
				
				params.put("code", "200");
				PrintWriter pw = response.getWriter();
				Gson g = new Gson();
				String str = g.toJson(params); 
				pw.write(str);
				pw.flush();
				pw.close();
			}else{
				params.put("message", "用户没有报过该兼职，不能操作！");
				params.put("code", "500");
				PrintWriter pw = response.getWriter();
				Gson g = new Gson();
				String str = g.toJson(params); 
				pw.write(str);
				pw.flush();
				pw.close();
			}

			//------------------访问限制--------开始----------------------
		}else{
			params.put("message", "无效访问");
			params.put("code", "404");
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
