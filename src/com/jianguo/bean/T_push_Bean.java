package com.jianguo.bean;

public class T_push_Bean {

	private int id;//
	private int login_id;//
	private String job_name;//
	private String title;//
	private String content;//
	private int type;//
	private String time;//
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String jobName) {
		job_name = jobName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public int getLogin_id() {
		return login_id;
	}
	
}
