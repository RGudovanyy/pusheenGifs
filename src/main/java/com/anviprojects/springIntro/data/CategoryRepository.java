package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
