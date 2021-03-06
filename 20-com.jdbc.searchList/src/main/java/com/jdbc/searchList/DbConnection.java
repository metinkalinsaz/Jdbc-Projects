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
			logger.warn("SQL DRİVER BULUNAMADI...");
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", "HR", "1234");
			logger.info("Sql'e baglandı..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.warn("sql'e baglanırken hata meydana gelkdi...");
		}

		return con;

	}

	public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("resulset kapatılırseken hata meydana geldi...");
			}
		}

		if (ps != null) {
			try {
				ps.close();
				logger.info("preparedstatement basarıyla kapatıldı...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("preparedstatement kapatılırken hata meydana geldı..." + e);
			}
		}

		if (con != null) {

			try {
				con.close();
				logger.info("sql kapatıldı");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("sql kapatyılırken hata meydana geldi..." + e);
			}

		}

	}

}
