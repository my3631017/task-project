package jdbc;

import java.sql.ResultSet;

public class Out {
    Out(ResultSet rs){
        try {
             while(rs.next()){
                 String id=rs.getString(1);
                 String name=rs.getString(2);
                 String number=rs.getString(3);
                 String create_at=rs.getString(4);
                 String update_at=rs.getString(5);
                 System.out.println(id+" "+name+" "+number+" "+create_at+" "+update_at);
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
