package com.proje.repository;

import java.util.List;

import com.proje.model.Brand;
/**
 * @author MetinKalinsaz
 */
public interface BrandRepository {

	Brand findBrandById(int id);

	List<Brand> findBrands();

}
