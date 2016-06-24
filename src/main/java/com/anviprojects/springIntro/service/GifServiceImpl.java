package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.data.GifAdditionalRepository;
import com.anviprojects.springIntro.data.GifRepository;
import com.anviprojects.springIntro.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anvi on 6/18/16.
 */
@Service
public class GifServiceImpl implements GifService{

    private GifRepository gifRepository;
    private GifAdditionalRepository gifAdditionalRepository;

    @Autowired
    public void setGifRepository(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }
    @Autowired
    public void setGifAdditionalRepository(GifAdditionalRepository gifAdditionalRepository){this.gifAdditionalRepository = gifAdditionalRepository;}

    @Override
    public Iterable<Gif> listGifs() {
        return gifRepository.findAll();
    }

    @Override
    public Gif saveGif(Gif rawGif) {
        List<Gif> allGifs = (List<Gif>) listGifs();
        for(Gif gif : allGifs){
            if(rawGif.getName().equals(gif.getName())) {
                return gif;
                //throw new NonUniqueResultException();
            }
        }
        if(rawGif.getCategoryId() == 0)
            rawGif.setCategoryId(3);
        if(rawGif.getUsername().equals(null) || rawGif.getUsername().equals(""))
            rawGif.setUsername("Anvi");
        rawGif.setDateUploaded(LocalDate.now());


        Gif gif = rawGif;
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
        List<Gif> listGifsByCategory = new ArrayList<Gif>();
        List<Gif> gifsFromDB = (List<Gif>) listGifs();
        if(!gifsFromDB.isEmpty()){
                for(Gif gif : gifsFromDB){
                    if(gif.getCategoryId() == categoryId)
                        listGifsByCategory.add(gif);
                }
        }
        return listGifsByCategory;
    }
}
