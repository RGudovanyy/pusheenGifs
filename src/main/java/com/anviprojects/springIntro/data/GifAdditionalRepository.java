package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.data.repository.Repository;

/**
 * This interface extends {@code Repository} interface, which allow to
 * develop custom methods to work with Repository Level. It used there
 * because the most common interface {@code CrudRepository} does not
 * provide the opportunity to find data in DB by String value
 *
 * {@see CrudRepository}
 */
public interface GifAdditionalRepository  extends Repository<Gif, String> {

    /**
     * Method used to get an object {@code Gif} from the DB by
     * name value.
     * @param name of gif
     * @return a reference to required object {@code Gif}
    */
    Gif findGifByName(String name);



}
