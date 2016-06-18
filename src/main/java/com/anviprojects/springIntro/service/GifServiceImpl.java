package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.data.GifRepository;
import com.anviprojects.springIntro.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anvi on 6/18/16.
 */
@Service
public class GifServiceImpl implements GifService{

    private GifRepository gifRepository;

    @Autowired
    public void setGifRepository(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @Override
    public List<Gif> listGifs() {
        ArrayList<Gif> gifs = new ArrayList<Gif>();
        gifs.add(new Gif("cat1",  1,"Anvi", LocalDate.of(2016,5,7), false));
        gifs.add(new Gif("cat2", 2,"Anvi", LocalDate.of(2016,5,7), false));
        gifs.add(new Gif("cat3", 1,"Anvi", LocalDate.of(2016,5,7), false));
        return gifs;
    }

    @Override
    public Gif saveGif(Gif gif) {
        return gifRepository.save(gif);
    }

    @Override
    public Gif getGifById(Integer id) {
        return gifRepository.findOne(id);
    }
}
