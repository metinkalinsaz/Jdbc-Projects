package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class UserProductQueries {
	public static final String saveUserProductQuery = "INSERT INTO USERPRODUCT(USERID ,PRODUCTID,existing) "
			+ "VALUES(?,?,?) ";

	public static final String findUserProductQuery = "SELECT * FROM  USERPRODUCT  UP LEFT  JOIN USERMY U  ON(U.USERID=UP.USERID) LEFT JOIN PRODUCT P ON(UP.PRODUCTID=P.PRODUCTID) LEFT JOIN BRAND B ON(P.BRANDID=B.BRANDID) LEFT JOIN CATEGORY C ON(P.CATEGORYID=C.CATEGORYID)   ";
}
