package com.proje.service;

import com.proje.model.UserProduct;
/**
 * @author MetinKalinsaz
 */
public interface UserProductService {
	boolean saveUserProduct(int user_id, int product_id); // Ara tablomuzdaki user_product daki bilgileri ekliyoruz

	UserProduct findUserProductById(); // user'�n kuland�g� �r�n(product) buluyoruz

}
