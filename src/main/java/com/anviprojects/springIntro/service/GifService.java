package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Gif;

/**
 * The interface contains methods to work with Repository Level
 * It used to pass and receive POJO of {@code Gif} class
 *
 * @author Roman Gudovanyy
 * @version 1.0
 * @see com.anviprojects.springIntro.data.GifRepository
 * @see com.anviprojects.springIntro.data.GifAdditionalRepository
 */
public interface GifService {

    /**
     * Method calls from the interface {@code GifRepository}
     * a list of all objects{@code Gif} class which stores in the DB
     * @return a collection of objects {@code Gif}
     */
    Iterable<Gif> listOfGifs();

    /**
     * Method pass to an interface {@code GifRepository} new object
     * of {@code Gif} class to save it in the DB
     * @param gif new {@code Category} object
     * @return a reference to new object
     */
    Gif saveGif(Gif gif);

    /**
     * Method receives form the interface {@code GifRepository} an
     * object {@code Gif} with defined identifier. The identifier generates
     * automatically when the new object is created
     * @param id identifier of {@code Gif} object
     * @return a reference to necessary {@code Gif} object
     */
    Gif getGifById(Integer id);

    /**
     * Method receives from the interface {@code GifAdditionalRepository} an
     * object of {@code Gif} class, which has defined param name
     * @param name name field of {@code Gif} object
     * @return a reference to necessary {@code Gif} object
     */
    Gif getGifByName(String name);

    /**
     * Method used to fetch from list of all objects of {@code Gif}
     * class, those objects that belong to the same category
     * @param categoryId identifier of the category
     * @return a collection of {@code Gif} objects
     */
    Iterable<Gif> getGifsByCategoryId(Integer categoryId);
}
