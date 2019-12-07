import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    public static String url;
    public static String user;
    public static String password;
    public static String driver;

    //文件的读取只需要一次即可，所以使用静态代码块。
    static{
        //读取文件资源，获取值
        try{
            //创建 Properties 集合类
            Properties pro = new Properties();

            //获取 src 路径下的文件的方式 --> ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //获取配置文件的路径
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();

            //加载文件
            pro.load(new FileReader(path));

            //获取数据，赋值
            url = path;
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
