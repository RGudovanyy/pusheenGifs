package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface implements methods from extended interface {@code CrudRepository}
 * Method findAll() returns all {@code Gif} objects of pre-configured entity from the DB
 * Method findOne(Integer id) returns one {@code Gif} object of pre-configured entity, which
 * has equivalent identifier, from the DB
 * Method save(Gif gif) save received {@code Gif} object to the DB and returns a reference
 * to that object
 * {@see RepositoryConfiguration}
 * {@see Gif}
 */
public interface GifRepository  extends CrudRepository<Gif, Integer>{

}
