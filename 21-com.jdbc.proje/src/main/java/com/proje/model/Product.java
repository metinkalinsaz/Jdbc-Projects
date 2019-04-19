package com.proje.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author MetinKalinsaz
 */

@Data
@AllArgsConstructor
public class Product {
	
	private int productId;
	private String productName;
	private double unitPrice;
	private int avaible;
	private Date addDate;
	private Date updateDate;
	private Category categoryId; // categori turunden arama yapab�l�r�z art�k
	private Brand brandId;   //brand turunden arama yapabu�l�r�z art�k
	

	
}
