package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Category;
import org.springframework.data.repository.Repository;

/**
 *
 */
public interface CategoryAdditionalRepository extends Repository<Category, String> {

    Category findCategoryByName(String name);
}
