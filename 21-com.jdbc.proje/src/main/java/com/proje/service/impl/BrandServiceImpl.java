package com.proje.service.impl;

import java.util.List;

import com.proje.model.Brand;
import com.proje.repository.BrandRepository;
import com.proje.repository.impl.BrandRepsitoryImpl;
import com.proje.service.BrandService;
/**
 * @author MetinKalinsaz
 */
public class BrandServiceImpl implements BrandService {

	private BrandRepository brandRepository = new BrandRepsitoryImpl();

	@Override
	public Brand findBrandById(int brandId) {

		return brandRepository.findBrandById(brandId);
	}

	@Override
	public List<Brand> findBrands() {
		return brandRepository.findBrands();
	}

}
