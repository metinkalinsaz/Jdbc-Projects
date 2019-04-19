package com.proje.service.impl;

import java.util.List;

import com.proje.model.Category;
import com.proje.repository.CategoryRepository;
import com.proje.repository.impl.CategoryRepositoryImpl;
import com.proje.service.CategoryService;
/**
 * @author MetinKalinsaz
 */
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

	@Override
	public Category findCategoryById(int categoryId) {
		return categoryRepository.findCategoryById(categoryId);
	}

	@Override
	public List<Category> findCategories() {
		return categoryRepository.findCategories();
	}
}
