package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Gif;

/**
 *
 */
public interface GifService {

    /**
     *
     * @return
     */
    Iterable<Gif> listOfGifs();

    /**
     *
     * @param gif
     * @return
     */
    Gif saveGif(Gif gif);

    /**
     *
     * @param id
     * @return
     */
    Gif getGifById(Integer id);

    /**
     *
     * @param name
     * @return
     */
    Gif getGifByName(String name);

    /**
     *
     * @param categoryId
     * @return
     */
    public Iterable<Gif> getGifsByCategoryId(Integer categoryId);
}
