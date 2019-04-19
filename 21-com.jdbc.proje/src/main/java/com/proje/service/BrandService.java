package com.proje.service;

import java.util.List;

import com.proje.model.Brand;
/**
 * @author MetinKalinsaz
 */
public interface BrandService {

	Brand findBrandById(int brandId);

	List<Brand> findBrands();
}
