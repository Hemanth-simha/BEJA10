package com.jspiders.marriage.first;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class RetrievePersonDetails {

	public static void main(String[] args) throws IOException {

		Connection CON = null;
		PreparedStatement PSTMT = null;
		ResultSet RS = null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);

			String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
			CON = DriverManager.getConnection(dburl);

			String query = " select photo from person " + " where contact = ? ";

			File file = new File("profile.jpg");
			FileOutputStream outputStream = new FileOutputStream(file);

			PSTMT = CON.prepareStatement(query);
			PSTMT.setLong(1, Long.parseLong(args[0]));
			RS = PSTMT.executeQuery();

			if (RS.next()) {
				InputStream inputStream = RS.getBinaryStream("photo");
				byte[] buffer = new byte[1024];
				while (inputStream.read(buffer) > 0) {
					outputStream.write(buffer);
				}
			}
			System.out.println("Profile Photo Found");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(CON!=null)
				{
					CON.close();
				}if(PSTMT!=null) {
					PSTMT.close();
				}if(RS!=null) {
					RS.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
