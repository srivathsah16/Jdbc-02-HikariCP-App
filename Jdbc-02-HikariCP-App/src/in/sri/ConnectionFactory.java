package in.sri;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource dataSource = null;
	//static block is executed only once when the Class is loaded into JVM
	static {
		try {
			File file = new File("DB.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);

			//Creating Connection Pool using HikariConfig
			HikariConfig config = new HikariConfig();
			String url = prop.getProperty("db.url");
			String uname = prop.getProperty("db.uname");
			String pwd = prop.getProperty("db.pwd");
			String maxPoolSize = prop.getProperty("db.maxPoolSize");
			String minIdle = prop.getProperty("db.minIdle");
			config.setJdbcUrl(url);
			config.setUsername(uname);
			config.setPassword(pwd);
			config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
			config.setMinimumIdle(Integer.parseInt(minIdle));

			dataSource = new HikariDataSource(config);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
