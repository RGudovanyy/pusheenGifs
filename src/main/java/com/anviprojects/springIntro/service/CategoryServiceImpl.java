package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.data.CategoryAdditionalRepository;
import com.anviprojects.springIntro.data.CategoryRepository;
import com.anviprojects.springIntro.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interface implementation {@code CategoryService}
 * {@see CategoryService}
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    CategoryRepository categoryRepository;
    CategoryAdditionalRepository categoryAdditionalRepository;

    @Autowired
    public void setCategoryRepository (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;   }

    @Autowired
    public void setCategoryAdditionalRepository(CategoryAdditionalRepository categoryAdditionalRepository){
        this.categoryAdditionalRepository = categoryAdditionalRepository;
    }

    @Override
    public Iterable<Category> listOfCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryAdditionalRepository.findCategoryByName(name);
    }

    public void categoriesAdding(){
        Category category1 = new Category(1, "Pushin Eats");
        categoryRepository.save(category1);


        Category category2 = new Category(2, "Pushin Plays");
        categoryRepository.save(category2);

        Category category3 = new Category(3, "Other stuff");
        categoryRepository.save(category3);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
