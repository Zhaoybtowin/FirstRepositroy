import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties properties = new Properties();
          //Druid中对配置文件的命名没有要求
        InputStream resourceAsStream = DruidDemo.class.getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);

        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //3.获取连接对象
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
