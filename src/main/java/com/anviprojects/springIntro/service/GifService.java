package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Gif;

import java.util.List;

/**
 *
 */
public interface GifService {
    List<Gif> listGifs();

    Gif saveGif(Gif gif);

    Gif getGifById(Integer id);

}
