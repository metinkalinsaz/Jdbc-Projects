package com.proje.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.connection.DBConnection;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.UserProduct;
import com.proje.model.Usermy;
import com.proje.model.queries.UserProductQueries;
import com.proje.repository.UserProductRepository;
/**
 * @author MetinKalinsaz
 */
public class UserProductRepositoryImpl implements UserProductRepository {
	private final Logger logger = (Logger) LogManager.getLogger();
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	DBConnection dBConnection = new DBConnection();

	

	@Override
	public boolean saveUserProduct(int user_id, int product_id) {

		Connection connection = dBConnection.openConnection();
		// "INSER INTO USER_PRODUCT (USER_ID,PRODUCT_ID)"
		try {
			preparedStatement = connection.prepareStatement(UserProductQueries.saveUserProductQuery);
			preparedStatement.setInt(1, user_id);
			preparedStatement.setInt(2, product_id);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.warn(" User_Product  kaydedilirken hata meydana geldi.HATA: " + e);
		} finally {

			dBConnection.closeConnection(connection, preparedStatement, resultSet);

		}
		return true;
	}

	@Override
	public UserProduct findUserProductById() {

		Connection connection = dBConnection.openConnection();

		/*
		 * findUserProductQuery="SELECT * FROM USERSPRODUCT UP " +
		 * "LEFT OUTER JOIN USERMY  U ON(UP.USERID=U.USERID) " +
		 * "LEFT JOIN PRODUCT P ON(UP.PRODUCTID=P.PRODUCTID) " +
		 * "LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID) " +
		 * "LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) " + "WHERE USERID=? "; }
		 */
		UserProduct userProduct = null;

		try {
			preparedStatement = connection.prepareStatement(UserProductQueries.findUserProductQuery);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				int existing = resultSet.getInt("existing");

				int userId = resultSet.getInt("userId");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				Date birthOfDate = resultSet.getDate("birthOfDate");
				String userName = resultSet.getString("userName");

				int productId = resultSet.getInt("productId");
				String productName = resultSet.getString("productName");
				double unitPrice = resultSet.getDouble("unitPrice");
				int avaible = resultSet.getInt("avaible");
				Date addDate = resultSet.getDate("addDate");
				Date updateDate = resultSet.getDate("updateDate");

				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");

				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");

				Usermy usermy = new Usermy(userId, firstName, lastName, birthOfDate, userName);
				Category category = new Category(categoryId, categoryName);
				Brand brand = new Brand(brandId, brandName);
				Product product = new Product(productId, productName, unitPrice, avaible, addDate, updateDate, category,
						brand);
				userProduct = new UserProduct(usermy, product, existing);

			}

		} catch (SQLException e) {
			logger.warn("usetr ve ürünleri bulurken hata meydana geldi..HATA:" + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return userProduct;
	}
}
