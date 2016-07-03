package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Category;
import org.springframework.data.repository.Repository;

/**
 * This interface extends {@code Repository} interface, which allow to
 * develop custom methods to work with Repository Level. It used there
 * because the most common interface {@code CrudRepository} does not
 * provide the opportunity to find data in DB by String value
 *
 * {@see GifRepository}
 */
public interface CategoryAdditionalRepository extends Repository<Category, String> {

    /**
     * Method used to get an object {@Category} from the DB by
     * name value.
     * @param name of category
     * @return a reference to required object {@code Category}
     */
    Category findCategoryByName(String name);
}
