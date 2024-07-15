package in.sri;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookStore {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("SELECT * FROM books");
		while (rSet.next()) {
			System.out.println(
					rSet.getInt("book_id") + "--" + rSet.getString("book_name") + "--" + rSet.getInt("book_price"));
		}
		rSet.close();
		stmt.close();
		con.close();
	}
}
