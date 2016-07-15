package com.jianguo.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jianguo.util.DButil;

public class T_tel_code_Sql {
	
	//判断该手机号是否已注册
	public static boolean check_tel(String tel){
		Connection conn=DButil.getCon();
		boolean b = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_tel_code where tel=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			b = rs.next();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static boolean check_tel_code(String tel,String code){
		Connection conn=DButil.getCon();
		boolean b = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_tel_code where tel=? and code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, code);
			rs = pstmt.executeQuery();
			b = rs.next();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public static int insert(String tel,String code){
		   int num=0;
		   Connection conn=DButil.getCon();
		   String sql="insert into t_tel_code(tel,code) values(?,?)";
		    PreparedStatement pst=DButil.getPstm(conn, sql);
		    try {
		    	pst.setString(1, tel);
		    	pst.setString(2, code);
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
	
	public static int update_tel(String code,String tel){
		int num=0;
		try {
			Connection conn=DButil.getCon();
			String sql = "update t_tel_code set code=? where tel=?";
			PreparedStatement psmt = DButil.getPstm(conn, sql);
			psmt.setString(1, code);
			psmt.setString(2, tel);
			num=psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
}
