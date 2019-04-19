package com.proje.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.connection.DBConnection;
import com.proje.model.Usermy;
import com.proje.model.queries.UserQueries;
import com.proje.repository.UserRepository;
/**
 * @author MetinKalinsaz
 */
public class UserRepositoryImpl implements UserRepository {

	private final Logger logger = (Logger) LogManager.getLogger();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	DBConnection dBConnection = new DBConnection();

	@Override
	public Usermy saveUser(Usermy usermy) {

		Connection connection = dBConnection.openConnection();
		// "USERMY(USER_ID,FIRST_NAME,LAST_NAME,BÝRD_OF_DATE,USER_NAME)
		// VALUES(?,?,?,?,?)"
		try {
			preparedStatement = connection.prepareStatement(UserQueries.saveUserQuery);
			preparedStatement.setInt(1, usermy.getUsersId());
			preparedStatement.setString(2, usermy.getFirstName());
			preparedStatement.setString(3, usermy.getLastName());
			preparedStatement.setDate(4, usermy.getBirthOfDate());
			preparedStatement.setString(5, usermy.getUserName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.warn(usermy.getUsersId() + "  id'li Usermy kaydedilirken hata meydana geldi.HATA: " + e);
		} finally {

			dBConnection.closeConnection(connection, preparedStatement, null);

		}

		return usermy;
	}

	@Override
	public Usermy updateUser(Usermy usermy) {
		Connection connection = dBConnection.openConnection();
		// "USERMY SET FIRST_NAME=?,LAST_NAME=?,BÝRD_OF_DATE=?,USER_NAME=? WHERE
		// USER_ID=?";

		try {
			preparedStatement = connection.prepareStatement(UserQueries.updateUserQuery);
			preparedStatement.setString(1, usermy.getFirstName());
			preparedStatement.setString(2, usermy.getLastName());
			preparedStatement.setDate(3, usermy.getBirthOfDate());
			preparedStatement.setString(4, usermy.getUserName());
			preparedStatement.setInt(5, usermy.getUsersId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.warn("Usermy güncellenirken hata meydana geldi..HATA: " + e);
		}

		finally {
			dBConnection.closeConnection(connection, preparedStatement, null);
		}

		return usermy;
	}

	@Override
	public boolean deleteUser(int id) {
		Connection connection = dBConnection.openConnection();

		// "DELETE FROM USERS_PRODUCT WHERE USER_ID=?";
		// "DELETE FROM USERMY WHERE USER_ID=? ";
		try {
			preparedStatement = connection.prepareStatement(UserQueries.deleteUsers_ProductByIdQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			preparedStatement = connection.prepareStatement(UserQueries.deleteUsersByIdQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			logger.warn("Usermy silinirken hata meydana geldþi..HATA: " + e);

		} finally {
			dBConnection.closeConnection(connection, preparedStatement, null);
		}

		return true;
	}

	@Override
	public Usermy findUserById(int id) {
		Connection connection = dBConnection.openConnection();
		// "SELECT * FROM USERMY WHERE USER_ID=?"
		// Veritabanýndan bir sey aradýgýmýzda resulset kullanýlýr...
		Usermy usermy = null;
		try {
			preparedStatement = connection.prepareStatement(UserQueries.findUsersById);

			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {// result set dolmusmu kontrol ett son elemana kadar ilerle
				int userId = resultSet.getInt("userId");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				Date birthOfDate = resultSet.getDate("birthOfDate");
				String userName = resultSet.getString("userName");

				usermy = new Usermy(userId, firstName, lastName, birthOfDate, userName);
			}

		} catch (SQLException e) {
			logger.warn("Usermy bulunurken hata meydana geldi..HATA: " + e);
		}

		finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return usermy;
	}

	@Override
	public List<Usermy> findUser() {

		Connection connection = dBConnection.openConnection();
		List<Usermy> usermies = new ArrayList<Usermy>();
		try {
			preparedStatement = connection.prepareStatement(UserQueries.findUsersQuery);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int userId = resultSet.getInt("userId");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				Date birthOfDate = resultSet.getDate("birthOfDate");
				String userName = resultSet.getString("userName");
				Usermy usermy = new Usermy(userId, firstName, lastName, birthOfDate, userName);
				usermies.add(usermy);
			}

		} catch (SQLException e) {
			logger.warn("Usermy listesi alýnýrken hata meydana geldi..HATA: " + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return usermies;
	}

}
