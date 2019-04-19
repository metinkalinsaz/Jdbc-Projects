package com.proje.model.queries;
/**
 * @author MetinKalinsaz
 */
public class CategoryQueries {

	// cATEGORÝDEN ID ILE TEK TEK ARAMA YAPMAK ICIN ...
	public static final String findCategoryByIdQuery = "SELECT * FROM CATEGORY WHERE CATEGORYID=?";
	// CATEGORYDEN TUMUNE ULASMAK ICIN
	public static final String findCategoryQery = "SELECT * FROM CATEGORY";

}
