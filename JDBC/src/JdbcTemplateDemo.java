import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcTemplateDemo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.创建 JdbcTemplate 对象
        //1.加载配置文件
        Properties properties = new Properties();
        //Druid中对配置文件的命名没有要求
        InputStream resourceAsStream = DruidDemo.class.getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);

        //2.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3.调用方法
        String sql = "update stu set score = 22 where id = ?";
//        int i = jdbcTemplate.update(sql,1);
//        System.out.println(i);
    }
}
