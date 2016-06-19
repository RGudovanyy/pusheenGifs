package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.data.repository.Repository;

/**
 *
 */

//TODO отрефакторить этот интерфейс, написать javadoc
public interface GifAdditionalRepository  extends Repository<Gif, String> {

    Gif findGifByName(String name);



}
