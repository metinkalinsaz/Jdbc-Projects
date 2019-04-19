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
import com.proje.model.Brand;
import com.proje.model.queries.BrandQueries;
import com.proje.repository.BrandRepository;
/**
 * @author MetinKalinsaz
 */
public class BrandRepsitoryImpl implements BrandRepository {

	private final Logger logger = (Logger) LogManager.getLogger();
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	DBConnection dBConnection = new DBConnection();

	@Override
	public Brand findBrandById(int id) {
		Brand brand = null;

		Connection connection = dBConnection.openConnection();
		// "SELECT * FROM BRAND WHERE BRANDID=?";
		try {
			preparedStatement = connection.prepareStatement(BrandQueries.findBrandByIdQuery);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");
				brand = new Brand(brandId, brandName);

			}

		} catch (SQLException e) {
			logger.warn("Brand Listesindeki eleman aranýrken hata meydana geldi..HATA: " + e);
		} finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return brand;
	}

	@Override
	public List<Brand> findBrands() {

		Connection connection = dBConnection.openConnection();
		// "SELECT * FROM BRAND";
		List<Brand> brands = new ArrayList<Brand>();
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(BrandQueries.findsBrandQery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int brandId = resultSet.getInt("brandId");
				String brandName = resultSet.getString("brandName");
				Brand brand = new Brand(brandId, brandName);
				brands.add(brand);

			}

		} catch (SQLException e) {
			logger.warn("Brand tüm listesi aranýrken hata meydana geldi..HATA:" + e);
		}

		finally {
			dBConnection.closeConnection(connection, preparedStatement, resultSet);
		}

		return brands;
	}

}
