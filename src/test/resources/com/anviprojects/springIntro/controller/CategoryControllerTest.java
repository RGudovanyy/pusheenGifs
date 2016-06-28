package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.model.Category;
import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.CategoryService;
import com.anviprojects.springIntro.service.GifService;
import com.anviprojects.springIntro.test.AbstractControllerTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 *
 */
@Transactional
public class CategoryControllerTest extends AbstractControllerTest{
    @Autowired
    private CategoryService categoryService;

    @Before
    public void setUp(){
        super.setUp();
        categoryService.categoriesAdding();
    }

    @Test
    public void testListCategories() throws Exception{

        String uri = "/categories";

        mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCategory() throws Exception {

        Category category = categoryService.getCategoryByName("Other stuff");
        Integer categoryId = category.getId();

        String uri = "/category/" + categoryId ;

        mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
    }


}