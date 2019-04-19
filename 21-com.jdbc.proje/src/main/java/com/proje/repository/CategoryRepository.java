package com.proje.repository;

import java.util.List;

import com.proje.model.Category;
/**
 * @author MetinKalinsaz
 */
public interface CategoryRepository {

	Category findCategoryById(int id);

	List<Category> findCategories();

}
