package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Category;

/**
 *
 */
public interface CategoryService {

    /**
     *
     * @return
     */
    Iterable <Category> listOfCategories();

    /**
     *
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     *
     * @param name
     * @return
     */
    Category getCategoryByName(String name);

    /**
     *
     */
    void categoriesAdding();

    /**
     *
     * @param category
     * @return
     */
    Category saveCategory(Category category);
}
