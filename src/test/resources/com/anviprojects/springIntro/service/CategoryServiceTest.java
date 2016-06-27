package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.test.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 *
 */
@Transactional
public class CategoryServiceTest extends AbstractTest {

    @Autowired
    public CategoryService categoryService;

    @Before
    public void setUp(){
        categoryService.categoriesAdding();
    }

    @Test
    public void testFindAll(){
        Collection<Category> list = (Collection<Category>) categoryService.listOfCategories();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertEquals("failure - expected size", 3, list.size());
    }

    @Test
    public void testFindById(){
        int id = 1;
        Category entity = categoryService.getCategoryById(id);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected id atribute match", id, entity.getId());
    }

    @Test
    public void testFindByName(){
        String name = "Other stuff";
        Category entity = categoryService.getCategoryByName(name);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected name atribute match", name, entity.getName());
    }

    @Test
    public void testCreate(){
        Category entity = new Category();
        entity.setId(4);
        entity.setName("Pusheen test");

        Category createdEntity = categoryService.saveCategory(entity);

        Assert.assertNotNull("failure - expected not null", createdEntity);
        Assert.assertNotNull("failure - expected id atribute not null", createdEntity.getId());
        Assert.assertNotNull("failure - expected name atribute not null", createdEntity.getName());

        Collection<Category> list = (Collection<Category>) categoryService.listOfCategories();
        Assert.assertEquals("failure - expected size", 4, list.size());
    }

}
