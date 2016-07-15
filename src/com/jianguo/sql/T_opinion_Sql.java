package com.jianguo.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jianguo.bean.T_opinion_Bean;
import com.jianguo.util.DButil;

public class T_opinion_Sql {
	
	public static int insert(String tel,String text,String time){
		   int num=0;
		   Connection conn=DButil.getCon();
		   String sql="insert into t_opinion(tel,text,time) values(?,?,?)";
		    PreparedStatement pst=DButil.getPstm(conn, sql);
		    try {
		    	pst.setString(1, tel);
		    	pst.setString(2, text);
		    	pst.setString(3, time);
				num=pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			finally{
				DButil.close(conn);
				DButil.psClose(pst);
			}
			return num;
	}
	
	public static T_opinion_Bean select_tel(String tel){
		ResultSet rs=null;
		T_opinion_Bean t_enroll_limit = new T_opinion_Bean();
		Connection conn=DButil.getCon();
		String sql = "select * from t_opinion where tel=?";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			psmt.setString(1,tel);
			rs=psmt.executeQuery();
			while(rs.next()){
				t_enroll_limit.setId(rs.getInt("id"));
				t_enroll_limit.setTel(rs.getString("tel")+"");
				t_enroll_limit.setText(rs.getString("text")+"");
				t_enroll_limit.setTime(rs.getString("time")+"");
			}
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn);
		}
		return t_enroll_limit;
	}
}
