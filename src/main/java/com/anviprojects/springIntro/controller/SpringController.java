package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.data.GifRepository;
import com.anviprojects.springIntro.data.GiftRepository;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SpringController {

    private GifService gifService;
    @Autowired
    private GiftRepository giftRepository;


    @Autowired
    public void setGifRepository(GifService gifService){
        this.gifService = gifService;
    }

    public List<Gif> getGifs(){
        return gifService.listGifs();
    }


    @RequestMapping("/") //мапируем URI который будет обрабатываться методом
    public String listGifts(ModelMap modelMap){
        //return "List of all the GIFs!"; // при переходе на страницу с URI "/" возвращаем эту строку
        List<Gif> allGifs = getGifs();
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
        modelMap.addAttribute("gif", new Gif());
        return "addnew";
    }

    @RequestMapping(value = "gif", method = RequestMethod.POST)
    public String saveGif(Gif gif){
        gifService.saveGif(gif);
        return "redirect:/gif/" + gif.getId();
    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        return "favorites";
    }
}


