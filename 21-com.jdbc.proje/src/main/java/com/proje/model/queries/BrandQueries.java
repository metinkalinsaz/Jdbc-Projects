package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class BrandQueries {
	// BRAND ID ILE TEK TEK ARAMA YAPMAK ICIN ...
	public static final String findBrandByIdQuery = "SELECT * FROM BRAND WHERE BRANDID=?";
	// BRAND TUMUNE ULASMAK ICIN
	public static final String findsBrandQery = "SELECT * FROM BRAND";
}
