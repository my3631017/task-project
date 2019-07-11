package com.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbcUtils.JDBCUtils;

public class LoginCheck {

    public static String check(String username,String password){
        try {
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String user_name = rs.getString("username");
                JDBCUtils.release(conn,ps,rs);
                return user_name;
            }
            JDBCUtils.release(conn,ps,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
