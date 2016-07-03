package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.data.GifAdditionalRepository;
import com.anviprojects.springIntro.data.GifRepository;
import com.anviprojects.springIntro.model.Gif;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface implementation {@code GifService}
 * {@see GifService}
 */

@Service
public class GifServiceImpl implements GifService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private GifRepository gifRepository;
    private GifAdditionalRepository gifAdditionalRepository;

    @Autowired
    public void setGifRepository(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }
    @Autowired
    public void setGifAdditionalRepository(GifAdditionalRepository gifAdditionalRepository){this.gifAdditionalRepository = gifAdditionalRepository;}

    @Override
    public Iterable<Gif> listOfGifs() {
        return gifRepository.findAll();
    }

    @Override
    public Gif saveGif(Gif rawGif) {
        List<Gif> allGifs = (List<Gif>) listOfGifs();
        for(Gif gif : allGifs){
            if(rawGif.getName().equals(gif.getName())) {
                log.warn("The gif " + rawGif.getName() + "already exists");
                return gif;
            }
        }
        if(rawGif.getCategoryId() == 0)
            rawGif.setCategoryId(1);
        if(rawGif.getUsername().equals(null) || rawGif.getUsername().equals(""))
            log.debug("Failed to read the username. Setting the standard username");
            rawGif.setUsername("Default user");
        log.debug("Setting the date");
        rawGif.setDateUploaded(LocalDate.now());

        Gif gif = rawGif;
        log.info("Write new gif " + gif.getName() + " to the database");
        return gifRepository.save(gif);
    }

    @Override
    public Gif getGifById(Integer id) {
        return gifRepository.findOne(id);
    }

    @Override
    public Gif getGifByName(String name) {
        return gifAdditionalRepository.findGifByName(name);
    }

    public Iterable<Gif> getGifsByCategoryId(Integer categoryId){
        List<Gif> listGifsByCategory = new ArrayList<>();
        List<Gif> gifsFromDB = (List<Gif>) listOfGifs();
        if(!gifsFromDB.isEmpty()){
                for(Gif gif : gifsFromDB){
                    if(gif.getCategoryId() == categoryId)
                        listGifsByCategory.add(gif);
                }
        }
        return listGifsByCategory;
    }
}
