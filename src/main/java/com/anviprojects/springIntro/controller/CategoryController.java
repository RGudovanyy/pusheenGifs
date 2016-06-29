package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.CategoryService;
import com.anviprojects.springIntro.service.GifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private CategoryService categoryService;
    private GifService gifService;
    @Autowired
    public void setCategoryRepository(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @Autowired
    public void setGifRepository(GifService gifService){
        this.gifService  = gifService;
    }


    public Iterable<Category> getCategory(){return categoryService.listOfCategories();}

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.put("categories", getCategory());
        log.debug("Loaded 'categories' template");
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryService.getCategoryById(id);
        modelMap.put("category", category);
        Iterable<Gif> gifs = gifService.getGifsByCategoryId(id);
        modelMap.put("gifs", gifs);
        log.debug("Loaded template for '" + category.getName() + "' category");
        return "category";
    }

}
