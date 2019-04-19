package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class ProductQueries {

	// iNSERT ÝNTO ÝLE VERÝ SAVE ÝÞLEMÝ YAPIYORUZ EKLIYORUZ...
	public static final String saveProductQery = "INSERT INTO "
			+ "PRODUCT(PRODUCTID,PRODUCTNAME,UNITPRICE,AVAIBLE,ADDDATE,UPDATEDATE,CATEGORYID,BRANDID) "
			+ "VALUES(?,?,?,?,?,?,?,?)";

	// UPDATE ÝLE VERÝ GUNCELLÝYORUZ...
	public static final String updatePoductQuery = "UPDATE PRODUCT SET "
			+ "PRODUCTNAME=?,UNITPRICE=?,AVAIBLE=?,UPDATEDATE=?,CATEGORYID=?,BRANDID=? " + "WHERE PRODUCTID=?";
	// ÝLK ÖNCE BAGLANTIYI KALDIR SONRA URUNU SIL.yANÝ URUNU SILEBILMEK ÝÇÝN ÝLK
	// ÖNCE BAGIMLILIGINI
	// SÝLMEMÝZ GEREKÝYOR
	// BAGIMLILIGINI SÝLÝYORUZ
	public static final String deleteUser_ProductQuery = "DELETE FROM  USERSPRODUCT WHERE PRODUCTID=? ";
	// ÞÝMDÝDE ÜRÜNÜMÜZÜ SÝLEBÝLÝRÝ ARTIK
	public static final String deleteProductQuery = "DELETE FROM PRODUCT WHERE PRODUCTID=? ";
//URUN VE BAGIMLILIKLARI SILINDI...

	// URUNU TEK TEK ARIYORSAK BU SEKILDE BULABILECEGÝZ...
	// tek urune select atan sorgumuz...
	public static final String findByProductIdQuery = "SELECT * FROM PRODUCT P  LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID) "
			+ "WHERE PRODUCTID=? ";

	// Tüm urunlerýmýzý göstermek istersek eger
	// tum urunlerýmýze select atan sorgumuz...
	public static final String findProductsOuery = "SELECT * FROM PRODUCT P LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID) LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID)";

}
