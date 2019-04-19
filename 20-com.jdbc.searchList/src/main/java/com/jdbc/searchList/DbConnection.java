package com.jdbc.searchList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
/**
 * @author MetinKalinsaz
 */
public class DbConnection {

	private Logger logger = (Logger) LogManager.getLogger();

	public Connection openConnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("SQL DRÝVER BULUNAMADI...");
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", "HR", "1234");
			logger.info("Sql'e baglandý..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("sql'e baglanýrken hata meydana gelkdi...");
		}

		return con;

	}

	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("resulset kapatýlýrseken hata meydana geldi...");
			}
		}

		if (ps != null) {
			try {
				ps.close();
				logger.info("preparedstatement basarýyla kapatýldý...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("preparedstatement kapatýlýrken hata meydana geldý..." + e);
			}
		}

		if (con != null) {

			try {
				con.close();
				logger.info("sql kapatýldý");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("sql kapatyýlýrken hata meydana geldi..." + e);
			}

		}

	}

}
