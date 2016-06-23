package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.AppConfig;
import com.anviprojects.springIntro.data.CategoryHelper;
import com.anviprojects.springIntro.data.CategoryRepository;
import com.anviprojects.springIntro.data.GifRepository;
import com.anviprojects.springIntro.data.GiftRepository;
import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.CategoryService;
import com.anviprojects.springIntro.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class SpringController {

    private GifService gifService;
    @Autowired
    private CategoryHelper categoryHelper;


    @Autowired
    public void setGifRepository(GifService gifService){
        this.gifService = gifService;
    }


    public Iterable<Gif> getGifs(){
        return gifService.listGifs();
    }





    @RequestMapping("/") //мапируем URI который будет обрабатываться методом
    public String listGifts(ModelMap modelMap){
        //return "List of all the GIFs!"; // при переходе на страницу с URI "/" возвращаем эту строку
        Iterable<Gif> allGifs = getGifs();
        modelMap.put("gifs", allGifs);
        return "home"; // указываем какой html-файл нужно вернуть. Thymeleaf находит его самостоятельно

    }


    @RequestMapping("/gif/{name}") // указываем по какому URI искать картинку
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("gif", gifService.getGifByName(name));
        return "gif-details";
    }


    /*
    @RequestMapping("/gif/{id}")
    public String gifDetailsById(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("gif", gifService.getGifById(id));
         return "gif-details";
    }
    */

    @RequestMapping(method = RequestMethod.GET, value = "/addnew")
    public String addNewGif(ModelMap modelMap){
        List<Category> allCategories = categoryHelper.getAllCategories();
        modelMap.addAttribute("gif", new Gif());
        modelMap.addAttribute("categoryList", allCategories);
        return "addnew";
    }



    @RequestMapping(value = "gif", method = RequestMethod.POST)
    //TODO реализовать проверку на дублирующие файлы. Сейчас вылетает Exception NonUniqueResultException
    public String saveGif(Gif gif, @RequestParam("file") MultipartFile file){
        try{
            String filename = file.getOriginalFilename();
            String filepath = Paths.get(AppConfig.ROOT + "/" + filename).toString();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
            stream.close();
            gifService.saveGif(gif);
            return "redirect:/gif/" + filename;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/addnew";


    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        return "favorites";
    }
}


