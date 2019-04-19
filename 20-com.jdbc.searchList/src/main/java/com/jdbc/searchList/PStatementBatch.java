package com.jdbc.searchList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
/**
 * @author MetinKalinsaz
 */
public class PStatementBatch {

	private static Logger logger = (Logger) LogManager.getLogger();

	public static Personel findByPersonelId(int Id) {
		String sorgu = "SELECT * FROM PERSON WHERE PERSON_NUMBER=?";
		DbConnection db = new DbConnection();
		Connection con = db.openConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Personel personel = null;
		try {
			preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, Id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int personelId = resultSet.getInt(1);
				String adi = resultSet.getString(2);
				String soyadi = resultSet.getNString(3);
				int numarasi = resultSet.getInt(4);
				personel = new Personel(personelId, adi, soyadi, numarasi);
			}

		} catch (Exception e) {
			logger.warn(Id + "Id'li Personel bulunurken hata meydana geldi.." + e);
		} finally {
			db.closeConnection(con, preparedStatement, resultSet);
		}

		return personel;

	}

	public List<Personel> findPersonels() {

		String sorgu = "SELECT * FROM PERSON ";
		DbConnection db = new DbConnection();
		Connection con = db.openConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		List<Personel> personels = new ArrayList<Personel>();
		try {
			preparedStatement = con.prepareStatement(sorgu);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {// result setimizi al bir sonraki veri varmý diye devamlý son veriye kadar git
										// dedýk

				int personelId = resultSet.getInt(1);
				String adi = resultSet.getString(2);
				String soyadi = resultSet.getNString(3);
				int numarasi = resultSet.getInt(4);
				Personel personel = new Personel(personelId, adi, soyadi, numarasi);
				personels.add(personel);
			}

		} catch (Exception e) {
			logger.warn("Personel listesi alýnýrken  hata meydana geldi..HATA: " + e);
		} finally {
			db.closeConnection(con, preparedStatement, resultSet);
		}

		return personels;
	}
}
