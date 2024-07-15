package in.sri;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadPersonImageFromDB {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rSet = stmt.executeQuery("SELECT * FROM PERSON");
		FileOutputStream fos = null;
		while (rSet.next()) {
			System.out.println("id=" + rSet.getInt(1) + ",name=" + rSet.getString(2) + ",image=" + rSet.getBlob(3));
			byte[] stream = rSet.getBytes(3);
			int empId = rSet.getInt(1);
			String empName = rSet.getString(2);
			fos = new FileOutputStream(
					"C:\\Users\\SRIVATH\\OneDrive - Capgemini\\Documents\\Courses\\AshokIT\\Advance Java\\Images\\OutputImages\\Image_empID_"
							+ empId + "_empName_" + empName + ".png");
			fos.write(stream);
		}
		fos.close();
		rSet.close();
		stmt.close();
		con.close();
	}
}
