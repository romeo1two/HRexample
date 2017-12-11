import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String args) {
		try {
			System.setOut(new PrintStream("out.txt"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return;
		}
		
		System.out.println("Copyright 2009");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/students?autoReconnect=true&useSSL=false";
			con = DriverManager.getConnection(url, "root", "R!omeo1two");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				String str = rs.getString(1) + ":" + rs.getString(2);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// this block required so that we can close all open connection and resources
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}

}
