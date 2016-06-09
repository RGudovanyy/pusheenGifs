package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GiftRepository {
    private static final List<Gif> ALL_GIFS  = Arrays.asList(
            new Gif("cat1",  1,"Anvi", LocalDate.of(2016,5,7), false),
            new Gif("cat2", 2,"Anvi", LocalDate.of(2016,5,7), false),
            new Gif("cat3", 1,"Anvi", LocalDate.of(2016,5,7), false),
            new Gif("cat4",3,"Anvi", LocalDate.of(2016,5,7), false),
            new Gif("cat5",2,"Anvi", LocalDate.of(2016,5,7), false),
            new Gif("cat6",3,"Anvi", LocalDate.of(2016,5,7), false)
    );

    public Gif findByName(String name){
        for(Gif f : ALL_GIFS){
            if(f.getName().equals(name))
                return f;
        }
        return null;
    }

    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }


    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<Gif>();
        for(Gif f : ALL_GIFS) {
            if (f.getCategoryId() == id)
                gifs.add(f);
        }
        return gifs;
    }
}
