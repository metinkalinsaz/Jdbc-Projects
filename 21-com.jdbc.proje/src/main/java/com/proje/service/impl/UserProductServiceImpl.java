package com.proje.service.impl;

import com.proje.model.UserProduct;
import com.proje.repository.UserProductRepository;
import com.proje.repository.impl.UserProductRepositoryImpl;
import com.proje.service.UserProductService;
/**
 * @author MetinKalinsaz
 */
public class UserProductServiceImpl implements UserProductService {

	private UserProductRepository userProductRepository = new UserProductRepositoryImpl();

	@Override
	public boolean saveUserProduct(int userId, int productId) {
		return userProductRepository.saveUserProduct(userId, productId);
	}

	@Override
	public UserProduct findUserProductById() {
		// TODO Auto-generated method stub
		return userProductRepository.findUserProductById();
	}

}
