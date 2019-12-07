import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo1 {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
        //1.导入jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Zhao12345");

        //开启事务
        connection.setAutoCommit(false);

        //4.定义sql语句
        String sql = "update stu set score = ? where name = ?";
        //5.获取执行SQL的 PreparedStatement 对象
        preparedStatement = connection.prepareStatement(sql);
        //!!为占位符赋值
        preparedStatement.setInt(1, 12);
        preparedStatement.setString(2, "林俊杰");
        //6.执行sql
        preparedStatement.executeQuery();

        //提交事务
        connection.commit();
    }catch(Exception e){

        //回滚事务
            try {
                if(null != connection){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
    }finally {
        //7.释放资源
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
