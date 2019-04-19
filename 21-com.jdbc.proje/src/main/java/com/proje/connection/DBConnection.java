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
	private static String driver; // File dosyamýzdan okunacak verilerin degiþkenini olusturuyoruz
	private static String url;
	private static String username;
	private static String password;

	static {
		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream("src/main/resources/database.properties");
			// file dosyamýzdaký verýlerý almak için verý yolunu girdik
			try {
				properties.load(inputStream); // okuma iþlemini yapýyoruz
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.warn("dosyadan okuma yapýlýrken hata meydana geldi..HATA: " + e);
			}
			;

			driver = properties.getProperty("db_driver"); // File dan okuma iþlemi yapýldý bilgiler alýndý...
			url = properties.getProperty("db_url");
			username = properties.getProperty("db_user");
			password = properties.getProperty("db_password");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Dosyadan input alýrken hata meydana geldi. HATA:" + e);
		}
	}

	public Connection openConnection() {

		Connection connection = null;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.warn("Driver bulunamadý.. HATA:" + e);
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
