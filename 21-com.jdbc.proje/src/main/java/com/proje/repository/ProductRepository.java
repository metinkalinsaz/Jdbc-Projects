package com.proje.repository;

import java.util.List;

import com.proje.model.Product;
/**
 * @author MetinKalinsaz
 */
public interface ProductRepository {

	Product saveProduct(Product product);

	boolean saveBatchProduct(List<Product> products);

	Product updateProduct(Product product);

	boolean deleteProduct(int productId);

	Product findProductById(int id);

	List<Product> findProducts();

}
