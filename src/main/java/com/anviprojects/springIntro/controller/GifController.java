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
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Controller to transfer data between View and Model
 * <p>This class contains methods to mapping URI using annotations {@code @RequestMapping}.
 * <p/>
 *
 * @author Roman Gudovanyy
 * @version 1.0
 * @see com.anviprojects.springIntro.service.GifService
 * @see com.anviprojects.springIntro.service.CategoryService
 */
@Controller
public class GifController {

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

    /**
     * @return a collection of all POJO objects {@link Gif} stored in DB
     */
    public Iterable<Gif> getGifs(){
        return gifService.listOfGifs();
    }

    /**
     * At the transition on URI '/' method receives a collection of all POJO objects {@link Gif}
     * and pass it to the View using {@code ModelMap}
     * @param modelMap
     * @return name of HTML template that display entities from collection
     * @see ModelMap
     */
    @RequestMapping("/")
    public String listGifts(ModelMap modelMap){
        Iterable<Gif> allGifs = getGifs();
        modelMap.put("gifs", allGifs);
        log.debug("Loaded home template");
        return "home";
    }

    /**
     * At the transition on URI '/gif/{name}' method requests from {@link GifService}
     * an entity using param {@code name} and pass it into {@code ModelMap}
     * @param name a name of entity
     * @param modelMap
     * @return name of HTML template that display single entity
     */
    @RequestMapping("/gif/{name}") // указываем по какому URI искать картинку
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("gif", gifService.getGifByName(name));
        log.debug("Loaded template for '" + name + "' gif");
        return "gif-details";
    }

    /**
     * At the transition on URI '/addnew' method creates new POJO object {@link Gif}
     * and through {@code ModelMap} pass it to the View
     * @param modelMap
     * @return name of HTML template that display a form to filling new object
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addnew")
    public String addNewGif(ModelMap modelMap){
        modelMap.addAttribute("gif", new Gif());
        log.debug("Loaded template to adding new gifs");
        return "addnew";
    }

    /**
     * This method receive from View a form with POJO object {@link Gif} and new {@code File}
     * object. Then the method pass POJO object to {@link GifService} and,
     *  if it is no exceptions, copies the file to a {@code ROOT} directory.
     *  If the exception was thown, method returns the name of HTML template with URI '/addnew'
     * @param gif an object received from ModelMap
     * @param file an object of an {@code File} class
     * @exception  IOException error to reading data from new {@code File} object
     * @return name of HTML template with the new entity
     */
    @RequestMapping(value = "gif", method = RequestMethod.POST)
    public String saveGif(Gif gif, @RequestParam("file") MultipartFile file){
        try{
            String filename = gif.getName() + ".gif";
            String filepath = Paths.get(AppConfig.ROOT + "/" + filename).toString();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
            stream.close();
            log.info("Try to add a new gif: " + filename);
            gifService.saveGif(gif);
            return "redirect:/gif/" + filename;
        }
        catch (IOException e){
            log.warn(e.getMessage());
        }
        return "redirect:/addnew";
    }

    /**
     * @param modelMap
     * @return name of HTML template that display entities which atribute {@code favorite} is true
     */
    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        log.debug("Loaded favorite template");
        return "favorites";
    }

    /**
     * @return a collection of categories
     */
    @ModelAttribute("categories")
    public Iterable<Category> populateCategories(){
        return categoryService.listOfCategories();
    }
}


