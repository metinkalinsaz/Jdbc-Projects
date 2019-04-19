package com.proje.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.connection.DBConnection;
import com.proje.model.Category;
import com.proje.model.queries.CategoryQueries;
import com.proje.repository.CategoryRepository;

/**
 * @author MetinKalinsaz
 */


public class CategoryRepositoryImpl implements CategoryRepository {

	private final Logger logger = (Logger) LogManager.getLogger();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Category category = null;
	

	DBConnection dBConnection = new DBConnection();

	@Override
	public Category findCategoryById(int id) {
		Connection connection = dBConnection.openConnection();
		// "SELECT * FROM CATEGORY WHERE CATEGORYID=?"
		try {
			preparedStatement = connection.prepareStatement(CategoryQueries.findCategoryByIdQuery);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");
				category = new Category(categoryId, categoryName);
			}

		} catch (SQLException e) {
			logger.warn("Category Listesi aranýrken hata meydana geldi..HATA: " + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return category;
	}

	@Override
	public List<Category> findCategories() {
		List<Category> categories = new ArrayList<Category>();
		Connection connection = dBConnection.openConnection();
		// "SELECT * FROM CATEGORY";
		try {
			preparedStatement = connection.prepareStatement(CategoryQueries.findCategoryQery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");
				category = new Category(categoryId, categoryName);
				categories.add(category);
			}

		} catch (SQLException e) {
			logger.warn("Category tüm Listesi aranýrken hata meydana geldi..HATA: " + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}
		return categories;

	}

}