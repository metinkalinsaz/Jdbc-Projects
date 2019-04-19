package com.proje.service;

import java.util.List;

import com.proje.model.Category;
/**
 * @author MetinKalinsaz
 */
public interface CategoryService {

	Category findCategoryById(int categoryId);

	List<Category> findCategories();
}
