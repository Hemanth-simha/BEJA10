package com.jspiders.job.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertCandidateDetials {

	public static void main(String[] args) throws FileNotFoundException {

		Connection CON = null;
		PreparedStatement PSTMT = null;
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);

			String dburl = "jdbc:mysql://localhost:3306/job?user=root&password=root";
			CON = DriverManager.getConnection(dburl);

			String query = " insert into candidate " + " values(?,?,?,?) ";

			File file = new File("C:\\jspiders\\J2ee Software\\Softwares\\Resources\\sample.txt");
			FileReader reader = new FileReader(file);

			PSTMT = CON.prepareStatement(query);
			PSTMT.setString(1, args[0]);
			PSTMT.setString(2, args[1]);
			PSTMT.setCharacterStream(3, reader);
			PSTMT.setLong(4, Long.parseLong(args[2]));

			int res = PSTMT.executeUpdate();

			if (res != 0) {
				System.out.println("Candidate Detials inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (CON != null) {
					CON.close();
				}
				if (PSTMT != null) {
					PSTMT.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
