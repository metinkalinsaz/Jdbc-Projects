package com.proje.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * @author MetinKalinsaz
 */
public class DBConnection {

	private static final Logger logger = (Logger) LogManager.getLogger();
	private static String driver; // File dosyam�zdan okunacak verilerin degi�kenini olusturuyoruz
	private static String url;
	private static String username;
	private static String password;

	static {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream("src/main/resources/database.properties");
			// file dosyam�zdak� ver�ler� almak i�in ver� yolunu girdik
			try {
				properties.load(inputStream); // okuma i�lemini yap�yoruz
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.warn("dosyadan okuma yap�l�rken hata meydana geldi..HATA: " + e);
			}
			;

			driver = properties.getProperty("db_driver"); // File dan okuma i�lemi yap�ld� bilgiler al�nd�...
			url = properties.getProperty("db_url");
			username = properties.getProperty("db_user");
			password = properties.getProperty("db_password");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Dosyadan input al�rken hata meydana geldi. HATA:" + e);
		}
	}

	public Connection openConnection() {

		Connection connection = null;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Driver bulunamad�.. HATA:" + e);
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
			logger.info("Connection sucseesful...");

		} catch (SQLException e) {
			logger.warn("Connection fail..HATA: " + e);
		}

		return connection;

	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
				logger.info("Connection closed...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("Connection not closed" + e);
			}

		}

		if (resultSet != null) {
			try {
				resultSet.close();
				logger.info("resulSet closed...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("resulSet not closed" + e);
			}

		}

		if (preparedStatement != null) {
			try {
				preparedStatement.close();
				logger.info("PreparedStatement closed...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.warn("PreparedStatement not closed :HATA" + e);
			}

		}

	}

}
