package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Category;

/**
 * An interface that contains methods to work with Repository Level
 *
 * @author Roman Gudovanyy
 * @version 1.0
 * @see com.anviprojects.springIntro.data.CategoryRepository
 * @see com.anviprojects.springIntro.data.CategoryAdditionalRepository
 */
public interface CategoryService {

    /**
     * This method calls form the interface {@code CategoryRepository} list of all categories
     * @return a collection of objects {@code Category} class
     */
    Iterable <Category> listOfCategories();

    /**
     * Method calls form the interface {@code CategoryRepository} an object of class{@code Category},
     * which must have an identifier equal to the received. Identifier must be unique
     * @param id an identifier of category
     * @return an object {@code Category} with equivalent id
     */
    Category getCategoryById(Integer id);

    /**
     * Method communicate with the interface {@code CategoryAdditionalRepository} to receiving
     * an object of {@code Category} class by name. Name must be unique
     * @param name of the category
     * @return an object {@code Category} with equivalent name
     */
    Category getCategoryByName(String name);

    /**
     * Auxiliary method that pass to an interface {@code CategoryRepository}
     * the list of objects {@code Category} which created recently
     * Therefore with the start of an application, the DB already has pre configured entities of
     * the {@code Category} class
     */
    void categoriesAdding();

    /**
     * Pass to the interface {@code CategoryRepository} a new
     * object of {@code Category} class with the fields filled in
     * @param category new object {@code Category}
     * @return a reference of created entity from DB
     */
    Category saveCategory(Category category);
}
