package in.sri;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPersonImageIntoDB {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		String insertSql = "INSERT INTO PERSON VALUES (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter person id::");
		pstmt.setInt(1, sc.nextInt());
		sc.nextLine();
		System.out.println("Enter person name::");
		pstmt.setString(2, sc.nextLine());
		File f = new File(
				"C:\\Users\\SRIVATH\\OneDrive - Capgemini\\Documents\\Courses\\AshokIT\\Advance Java\\Images\\person3.jpg");
		FileInputStream fis = new FileInputStream(f);
		pstmt.setBlob(3, fis);
		//setBinaryStream can also be used.
		pstmt.setBinaryStream(3, fis);
		pstmt.executeUpdate();
		System.out.println("Inserted");
		pstmt.close();
		con.close();
	}
}
