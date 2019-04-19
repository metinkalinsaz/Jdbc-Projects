package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class ProductQueries {

	// iNSERT �NTO �LE VER� SAVE ��LEM� YAPIYORUZ EKLIYORUZ...
	public static final String saveProductQery = "INSERT INTO "
			+ "PRODUCT(PRODUCTID,PRODUCTNAME,UNITPRICE,AVAIBLE,ADDDATE,UPDATEDATE,CATEGORYID,BRANDID) "
			+ "VALUES(?,?,?,?,?,?,?,?)";

	// UPDATE �LE VER� GUNCELL�YORUZ...
	public static final String updatePoductQuery = "UPDATE PRODUCT SET "
			+ "PRODUCTNAME=?,UNITPRICE=?,AVAIBLE=?,UPDATEDATE=?,CATEGORYID=?,BRANDID=? " + "WHERE PRODUCTID=?";
	// �LK �NCE BAGLANTIYI KALDIR SONRA URUNU SIL.yAN� URUNU SILEBILMEK ���N �LK
	// �NCE BAGIMLILIGINI
	// S�LMEM�Z GEREK�YOR
	// BAGIMLILIGINI S�L�YORUZ
	public static final String deleteUser_ProductQuery = "DELETE FROM  USERSPRODUCT WHERE PRODUCTID=? ";
	// ��MD�DE �R�N�M�Z� S�LEB�L�R� ARTIK
	public static final String deleteProductQuery = "DELETE FROM PRODUCT WHERE PRODUCTID=? ";
//URUN VE BAGIMLILIKLARI SILINDI...

	// URUNU TEK TEK ARIYORSAK BU SEKILDE BULABILECEG�Z...
	// tek urune select atan sorgumuz...
	public static final String findByProductIdQuery = "SELECT * FROM PRODUCT P  LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID) "
			+ "WHERE PRODUCTID=? ";

	// T�m urunler�m�z� g�stermek istersek eger
	// tum urunler�m�ze select atan sorgumuz...
	public static final String findProductsOuery = "SELECT * FROM PRODUCT P LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID)";

}
