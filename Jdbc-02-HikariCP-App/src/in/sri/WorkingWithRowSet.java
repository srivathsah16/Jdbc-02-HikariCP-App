package in.sri;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class WorkingWithRowSet {
	public static void main(String[] args) throws Exception {
		//Accessing the properties using Properties file
		Properties p = new Properties();
		File file = new File("DB.properties");
		FileInputStream fis = new FileInputStream(file);
		p.load(fis);
		String url = p.getProperty("db.url");
		String uname = p.getProperty("db.uname");
		String pwd = p.getProperty("db.pwd");
		
		//Working with RowSet
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl(url);
		rowSet.setUsername(uname);
		rowSet.setPassword(pwd);
		rowSet.setCommand("SELECT * FROM BOOKS");
		rowSet.execute();
		while (rowSet.next()) {
			System.out.println(rowSet.getInt(1) + "--" + rowSet.getString(2) + "--" + rowSet.getInt(3));
		}
		rowSet.close();
	}
}
