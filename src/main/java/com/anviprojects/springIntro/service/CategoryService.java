package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Category;

/**
 *
 */
public interface CategoryService {

    Iterable <Category> listOfCategories();

    Category getCategoryById(Integer id);

    Category getCategoryByName(String name);

    void categoriesAdding();

    Category saveCategory(Category category);
}
