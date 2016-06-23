package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Gif;

/**
 *
 */
public interface GifService {
    Iterable<Gif> listGifs();

    Gif saveGif(Gif gif);

    Gif getGifById(Integer id);

    Gif getGifByName(String name);

    public Iterable<Gif> getGifsByCategoryId(Integer categoryId);
}
