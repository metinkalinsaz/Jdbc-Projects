package com.proje.repository;

import com.proje.model.UserProduct;
/**
 * @author MetinKalinsaz
 */
public interface UserProductRepository {
	boolean saveUserProduct(int user_id, int product_id); // Ara tablomuzdaki user_product daki bilgileri ekliyoruz

	UserProduct findUserProductById();

}
