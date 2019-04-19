package com.proje.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.proje.connection.DBConnection;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.queries.ProductQueries;
import com.proje.repository.ProductRepository;
/**
 * @author MetinKalinsaz
 */
public class ProductRepositoryImpl implements ProductRepository {

	private final Logger logger = (Logger) LogManager.getLogger();
	private final Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	DBConnection dBConnection = new DBConnection();
 
	@Override
	public Product saveProduct(Product product) {

		Connection connection = dBConnection.openConnection();

		/*
		 * /saveProductQery="INSERT INTO " +
		 * "PRODUCT(PRODUCT_ID,PRODUCT_NAME,UNITPRÝCE,AVAIBLE,ADD_DATE,UPDATE,CATEGORY_ID,BRAND_ID"
		 * + "VALUES(?,?,?,?,?,?,?,?))"
		 */

		try {
			LocalDateTime localDateTime = LocalDateTime.now();
			preparedStatement = connection.prepareStatement(ProductQueries.saveProductQery);
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getUnitPrice());
			preparedStatement.setInt(4, product.getAvaible());
			preparedStatement.setTimestamp(5, Timestamp.valueOf(localDateTime));
			preparedStatement.setTimestamp(6, null);
			preparedStatement.setInt(7, product.getCategoryId().getCategoryId());

			preparedStatement.setInt(8, product.getBrandId().getBrandId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.warn("Ürün eklenirken hata oluþtu...Hata: " + e);

		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return product;
	}

	@Override
	public boolean saveBatchProduct(List<Product> products) {
		Connection connection = dBConnection.openConnection();

		try {
			LocalDateTime localDateTime = LocalDateTime.now();
			preparedStatement = connection.prepareStatement(ProductQueries.saveProductQery);

			for (Product product : products) {
				preparedStatement.setInt(1, product.getProductId());
				preparedStatement.setString(2, product.getProductName());
				preparedStatement.setDouble(3, product.getUnitPrice());
				preparedStatement.setInt(4, product.getAvaible());
				preparedStatement.setTimestamp(5, Timestamp.valueOf(localDateTime));
				preparedStatement.setTimestamp(5, null);
				preparedStatement.setInt(7, product.getCategoryId().getCategoryId());

				preparedStatement.setInt(8, product.getBrandId().getBrandId());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			logger.warn("Ürün Listesi eklenirken hata oluþtu...Hata: " + e);
			return false;
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return true;
	}

	@Override
	public Product updateProduct(Product product) {

		Connection connection = dBConnection.openConnection();
		LocalDateTime localDateTime = LocalDateTime.now();
		/*
		 * updatePoductQuery="UPDATE PRODUCT SET " +
		 * "PRODUCT_NAME=?,UNITPRÝCE=?,AVAIBLE=?,UPDATE=?,CATEGORY_ID=?,BRAND_ID=? " +
		 * "WHERE PRODUCT_ID=?";
		 */

		try {
			preparedStatement = connection.prepareStatement(ProductQueries.updatePoductQuery);

			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setDouble(2, product.getUnitPrice());
			preparedStatement.setInt(3, product.getAvaible());
			preparedStatement.setTimestamp(4, Timestamp.valueOf(localDateTime));
			preparedStatement.setInt(5, product.getCategoryId().getCategoryId());
			preparedStatement.setInt(6, product.getBrandId().getBrandId());
			preparedStatement.setInt(7, product.getProductId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.warn("Update yapýlýrken hata meydana geldi..HATA:" + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return product;
	}

	@Override
	public boolean deleteProduct(int productId) {
		Connection connection = dBConnection.openConnection();
		// "DELETE FROM USERS_PRODUCT WHERE PRODUCT_ID=? ";
		try {
			preparedStatement = connection.prepareStatement(ProductQueries.deleteUser_ProductQuery);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
			// "DELETE FROM PRODUCT WHERE PRODUCT_ID=? ";
			preparedStatement = connection.prepareStatement(ProductQueries.deleteProductQuery);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.warn("Usermy product silinirken hata meydana geldi..HATA:" + e);
		}

		finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return true;
	}

	@Override
	public Product findProductById(int productId) {
		Connection connection = dBConnection.openConnection();
		Product product = null;

		try {
			/*
			 * "SELECT * FROM PRODUCT P " +
			 * "LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) " +
			 * "LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID) " + "WHERE PRODUCTID=? ";
			 */
			preparedStatement = connection.prepareStatement(ProductQueries.findByProductIdQuery);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int productsId = resultSet.getInt("productId");
				String productName = resultSet.getString("productName");
				double unitPrice = resultSet.getDouble("unitPrice");
				int avaible = resultSet.getInt("avaible");
				Date addDate = resultSet.getDate("addDate");
				Date updateDate = resultSet.getDate("updateDate");

				int categoryId = resultSet.getInt("categoryId");
				String categoryName = resultSet.getString("categoryName");

				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");

				Category category = new Category(categoryId, categoryName);
				Brand brand = new Brand(brandId, brandName);

				product = new Product(productsId, productName, unitPrice, avaible, addDate, updateDate, category,
						brand);
			}

		} catch (SQLException e) {
			logger.warn(productId + "id'li ürün alýnýrken hata meydana geldi..HATA:" + e);

		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return product;
	}

	@Override
	public List<Product> findProducts() {

		Connection connection = dBConnection.openConnection();
		List<Product> products = new ArrayList<Product>();
		Product product = null;

		// "SELECT * FROM PRODUCT P LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID)
		// LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID)";

		try {
			preparedStatement = connection.prepareStatement(ProductQueries.findProductsOuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
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

				Category category = new Category(categoryId, categoryName);
				Brand brand = new Brand(brandId, brandName);

				product = new Product(productId, productName, unitPrice, avaible, addDate, updateDate, category, brand);
				products.add(product);
			}
		} catch (SQLException e) {
			logger.warn("Ürünler listelenirken hata meydana geldi..HATA: " + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return products;
	}

}
