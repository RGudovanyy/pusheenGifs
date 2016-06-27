package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.data.repository.Repository;

/**
 *
 */


public interface GifAdditionalRepository  extends Repository<Gif, String> {

    Gif findGifByName(String name);



}
