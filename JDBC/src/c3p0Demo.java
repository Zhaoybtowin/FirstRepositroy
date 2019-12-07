import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        //调用其他连接池
        //DataSource dataSource1 = new ComboPooledDataSource("otherc3p0");

        for(int i = 1;i <= 11;i++){  //故意超过最大连接数10
            //获取连接
            Connection connection = dataSource.getConnection();

            System.out.println(i +".  "+ connection);

            if(i == 5) //让连接中途归还，看结果中连接对象信息，是否有相同的对象（证明归还了）
                connection.close();
        }

//        Connection connection = dataSource.getConnection();
//
//        String sql = "update stu set score = 2 where id = 1";
//
//        Statement statement = connection.createStatement();
//        System.out.println(statement.executeUpdate(sql));
//        connection.close();//归还到连接池中
    }
}
