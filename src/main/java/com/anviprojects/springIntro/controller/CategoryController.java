package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.data.CategoryRepository;
import com.anviprojects.springIntro.data.GiftRepository;
import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GiftRepository giftRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories", allCategories);

        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);
        List<Gif> gifs = giftRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
