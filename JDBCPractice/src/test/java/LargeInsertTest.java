import jdbc.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LargeInsertTest {
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    @Test
    public void largeInsert(){
        Long t1=System.currentTimeMillis();
        System.out.println("开始");
        try {
            conn=JDBCUtils.getConnection();
            String sql = "insert into tb_test (name,number,create_at,update_at) values(?,?,?,?)";
            stmt=conn.prepareStatement(sql);
            Long time;
            for (int i=1;i<=10000;i++){
            time=System.currentTimeMillis();
            stmt.setString(1,"stu"+i);
            stmt.setString(2,"chengdu"+i);
            stmt.setLong(3,time);
            stmt.setLong(4,time);
            stmt.addBatch();
            //每1000条插入一次
            if (i%1000==0){
                stmt.executeBatch();
                stmt.clearBatch();
            }
            }
            //防止有零头没插入
            stmt.executeBatch();
            stmt.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,stmt,rs);
        }
        Long t2=System.currentTimeMillis();
        System.out.println("结束");
        System.out.println("用时:"+(t2-t1)+"ms");
    }
}
