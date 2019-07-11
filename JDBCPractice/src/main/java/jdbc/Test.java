package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
    public static void main(String[] args) throws Exception{
        String diver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://47.106.176.177:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="ll..123";
        Class.forName(diver);
        Connection conn=DriverManager.getConnection(url,username,password);
        PreparedStatement stmt=conn.prepareStatement("insert into tb_test (name,number)values(?,?) ");
        stmt.setString(1,"万全林");
        stmt.setString(2,"123456");
        stmt.executeUpdate();
    }
}
