package com.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbcUtils.JDBCUtils;

public class RegisterCheck {

    public static boolean registerCheck(String username, String password) {
        try {
            //检查是否有相同的账号已被注册，如果没有被注册rs.next()会返回false
            Connection conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from user where username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                ps = conn.prepareStatement("insert into user (username,password) values (?,?)");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.executeUpdate();
                System.out.println("注册成功");
                JDBCUtils.release(conn, ps, rs);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}