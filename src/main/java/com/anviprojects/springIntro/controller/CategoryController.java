package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.CategoryService;
import com.anviprojects.springIntro.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

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



    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        //categoryService.categoriesAdding();
        Iterable<Category> allCategories = categoryService.listOfCategories();
        modelMap.put("categories", allCategories);

        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryService.getCategoryById(id);
        modelMap.put("category", category);
        Iterable<Gif> gifs = gifService.getGifsByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }

    @ModelAttribute("categoryList")
    public List<Category> populateCategories(){
        return (List<Category>) categoryService.listOfCategories();
    }
}
