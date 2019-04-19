package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class UserQueries {

	// USER EKLEDIGIMIZ ZAMAN EXTRA OLARAK USER PRODUCT DA EKLEMEMIZ GEREKIYOR
	public static final String saveUserQuery = " INSERT INTO  "
			+ " USERMY(USERID,FIRSTNAME,LASTNAME,BIRTHOFDATE,USERNAME) VALUES(?,?,?,?,?)  ";

	// USER PRODUCT EKLEDIK

	// gUNCELLEME ÝÞLEMÝNÝDE YAPTIK...
	public static final String updateUserQuery = "UPDATE "
			+ " USERMY SET FIRSTNAME=?,LASTNAME=?,BIRTHOFDATE=?,USERNAME=?" + "WHERE USERID=?";

	// BAGIMLILIGI OLAN TABLODAKI VERIYI SILDIK USERMY IN.USER_PRODUCT TABLOSUNDAKI
	// VERI SILINDI
	public static final String deleteUsers_ProductByIdQuery = "DELETE FROM USERPRODUCT WHERE USERID=?";

//USERMY TABLOSUNDAKI VERI SILINDI...
	public static final String deleteUsersByIdQuery = "DELETE FROM USERMY WHERE USERID=? ";

	// USER A AÝT OLAN BÝLGÝLERÝ ID ILE TEK TEK BULUYORUZ..
	public static final String findUsersById = "SELECT * FROM USERMY WHERE USERID=? ";

	// uSERS A AIT OLAN BILGILERIN TAMAMINI BULUYORUZ...
	public static final String findUsersQuery = "SELECT * FROM USERMY ";

}
