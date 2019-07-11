package jdbc;

import dao.UserDao;

import java.sql.*;
public class Demo implements UserDao {
    private Connection conn;
    private PreparedStatement sql;
    private ResultSet rs;
    public void select() {
        try {
            conn = JDBCUtils.getConnection();
            sql = conn.prepareStatement("select * from tb_test");
            rs=sql.executeQuery();
            new Out(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//关闭流
            JDBCUtils.release(conn,sql,rs);
        }
    }
    public void select(int i){
        try {
            conn = JDBCUtils.getConnection();
            sql = conn.prepareStatement("select * from tb_test where id=?");
            sql.setInt(1,i);
            rs=sql.executeQuery();
            new Out(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {//关闭流
            JDBCUtils.release(conn,sql,rs);
        }
    }
    public void insert(int id,String name,String number){
        Long time=System.currentTimeMillis();
        try {
            conn= JDBCUtils.getConnection();
            sql=conn.prepareStatement("insert into tb_test values (?,?,?,?,?)");
            sql.setInt(1,id);
            sql.setString(2,name);
            sql.setString(3,number);
            sql.setLong(4,time);//插入时间
            sql.setLong(5,time);//修改时间
            int i=sql.executeUpdate();
            System.out.println("成功插入"+i+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,sql,rs);
        }
    }
    public void delete(int id){
        try {
            conn= JDBCUtils.getConnection();
            sql=conn.prepareStatement("delete from tb_test where id=?");
            sql.setInt(1,id);
            int i=sql.executeUpdate();
            System.out.println("成功删除"+i+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,sql,rs);
        }
    }
    public void update(int id,String name,String number){
        Long time=System.currentTimeMillis();
        try {
            conn= JDBCUtils.getConnection();
            sql=conn.prepareStatement("update tb_test set name=?,number=?,update_at=? where id=?");
            sql.setString(1,name);
            sql.setString(2,number);
            sql.setLong(3,time);//修改时间
            sql.setInt(4,id);
            int i=sql.executeUpdate();
            System.out.println("成功修改"+i+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,sql,rs);
        }
    }
}
