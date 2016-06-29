package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.AppConfig;
import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.CategoryService;
import com.anviprojects.springIntro.service.GifService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;


@Controller
public class SpringController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private GifService gifService;

    private CategoryService categoryService;

    //TODO добавить проверку имени на валидность - без проблелов


    @Autowired
    public void setGifRepository(GifService gifService){
        this.gifService = gifService;
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService){this.categoryService=categoryService;}

    public Iterable<Gif> getGifs(){
        return gifService.listGifs();
    }


    @RequestMapping("/") //мапируем URI который будет обрабатываться методом
    public String listGifts(ModelMap modelMap){
        //return "List of all the GIFs!"; // при переходе на страницу с URI "/" возвращаем эту строку
        Iterable<Gif> allGifs = getGifs();
        modelMap.put("gifs", allGifs);
        log.debug("Loaded home template");
        return "home"; // указываем какой html-файл нужно вернуть. Thymeleaf находит его самостоятельно

    }


    @RequestMapping("/gif/{name}") // указываем по какому URI искать картинку
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("gif", gifService.getGifByName(name));
        log.debug("Loaded template for '" + name + "' gif");
        return "gif-details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addnew")
    public String addNewGif(ModelMap modelMap){
        modelMap.addAttribute("gif", new Gif());
        log.debug("Loaded template to adding new gifs");
        return "addnew";
    }



    @RequestMapping(value = "gif", method = RequestMethod.POST)
    public String saveGif(Gif gif, @RequestParam("file") MultipartFile file){
        try{
            String filename = file.getOriginalFilename();
            String filepath = Paths.get(AppConfig.ROOT + "/" + filename).toString();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
            stream.close();
            log.info("Try to add a new gif: " + filename);
            gifService.saveGif(gif);
            return "redirect:/gif/" + filename;
        }
        catch (Exception e){
            log.warn(e.getMessage());
        }
        return "redirect:/addnew";


    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        log.debug("Loaded favorite template");
        return "favorites";
    }

    @ModelAttribute("categories")
    public Iterable<Category> populateCategories(){
        return categoryService.listOfCategories();
    }
}


