package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.data.GiftRepository;
import com.anviprojects.springIntro.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpringController {

    @Autowired
    private GiftRepository giftRepository;


    @RequestMapping("/") //мапируем URI который будет обрабатываться методом
    public String listGifts(ModelMap modelMap){
        //return "List of all the GIFs!"; // при переходе на страницу с URI "/" возвращаем эту строку
        List<Gif> allGifs = giftRepository.getAllGifs();
        modelMap.put("gifs", allGifs);

        return "home"; // указываем какой html-файл нужно вернуть. Thymeleaf находит его самостоятельно

    }

    @RequestMapping("/gif/{name}") // указываем по какому URI искать картинку
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = giftRepository.findByName(name); //запрашиваем картинку по ее имени, выдернотому из URI
        modelMap.put("gif",gif);
        return "gif-details";
    }

    @RequestMapping("/addnew")
    public String addNewGif(ModelMap modelMap){
        return "addnew";
    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        return "favorites";
    }
}


