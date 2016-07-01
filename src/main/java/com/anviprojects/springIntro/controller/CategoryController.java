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

/**
 * This class provides interaction between View (thymeleaf templates) and Model (CategoryService)
 * <p>When controller receives a query for a relative path, it calls
 *  appropriate method to return a necessary template<p/>
 *
 * @author Roman Gudovanyy
 * @version  1.0
 * @see org.springframework.stereotype.Controller
 * @see com.anviprojects.springIntro.service.CategoryService
 * @see com.anviprojects.springIntro.model.Category
 */
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

    /**
     * When CategoryController is loaded this method requests from {@link CategoryService}
     * all existing Categories
     * @return  the list of Categories
     */
    public Iterable<Category> getCategory(){return categoryService.listOfCategories();}


    /**
     * Method get a collection all objects of POJO class {@link Category} and through {@code ModelMap}
     * pass them to the View level
     * @param modelMap
     * @return name of HTML template that display entities from collection
     */
    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.put("categories", getCategory());
        log.debug("Loaded 'categories' template");
        return "categories";
    }

    /**
     * This method uses param {@code id} to receive on object of {@link Category} class
     * from {@link CategoryService}. Then this param pass to {@link GifService} to
     *  select objects of {@link Gif} class that appropriate previously obtained category
     * @param id номер категории
     * @param modelMap
     * @return name of HTML template with the collection of POJO of {@link Gif} class that
     * belongs to this category
     */
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
