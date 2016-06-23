package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.data.CategoryAdditionalRepository;
import com.anviprojects.springIntro.data.CategoryRepository;
import com.anviprojects.springIntro.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anvi on 6/20/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    public void categoriesAdding(){
        Category category1 = new Category(1, "Pushin Eats");
        categoryRepository.save(category1);

        Category category2 = new Category(2, "Pushin Plays");
        categoryRepository.save(category2);

        Category category3 = new Category(3, "Other stuff");
        categoryRepository.save(category3);
    }

    CategoryRepository categoryRepository;
    CategoryAdditionalRepository categoryAdditionalRepository;

    @Autowired
    public void setCategoryRepository (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


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
}
