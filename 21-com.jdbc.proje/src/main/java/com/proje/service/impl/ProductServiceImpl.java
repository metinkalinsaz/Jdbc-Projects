package com.proje.service.impl;

import java.util.List;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;
import com.proje.repository.impl.ProductRepositoryImpl;
import com.proje.service.ProductService;
/**
 * @author MetinKalinsaz
 */
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	@Override
	public Product saveProduct(Product product) {
		return productRepository.saveProduct(product);
	}

	@Override
	public boolean saveBatchProduct(List<Product> products) {
		return productRepository.saveBatchProduct(products);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productRepository.deleteProduct(productId);
	}

	@Override
	public Product findProductById(int productId) {
		return productRepository.findProductById(productId);
	}

	@Override
	public List<Product> findProducts() {
		return productRepository.findProducts();
	}

}
