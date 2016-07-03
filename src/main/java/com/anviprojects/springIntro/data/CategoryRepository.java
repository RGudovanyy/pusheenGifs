package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface implements methods from extended interface {@code CrudRepository}
 * Method findAll() returns all {@code Category} objects of pre-configured entity from the DB
 * Method findOne(Integer id) returns one {@code Category} object of pre-configured entity, which
 * has equivalent identifier, from the DB
 * Method save(Category category) saves received object to the DB and returns a reference
 * to that object
 * {@see RepositoryConfiguration}
 * {@see Category}
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
