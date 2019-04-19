package com.proje.service;

import java.util.List;

import com.proje.model.Product;
/**
 * @author MetinKalinsaz
 */
public interface ProductService {

	Product saveProduct(Product product);

	boolean saveBatchProduct(List<Product> products);

	Product updateProduct(Product product);

	boolean deleteProduct(int productId);

	Product findProductById(int productId);

	List<Product> findProducts();

}
