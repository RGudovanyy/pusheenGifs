package com.anviprojects.springIntro.controller;

import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.service.GifService;
import com.anviprojects.springIntro.test.AbstractControllerTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;


/**
 *
 */
@Transactional
public class GifControllerTest extends AbstractControllerTest {


    @Autowired
    public GifService gifService;

    Integer gifId;

    @Before
    public void setUp(){
        super.setUp();
        Gif gif = new Gif("cat1", 1 , "Anvi", LocalDate.now(),false);
        Gif savedGif = gifService.saveGif(gif);
        gifId = savedGif.getId();
    }

    @Test
    public void testListGifs() throws Exception {

        String uri = "/";

        mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGifDetails() throws Exception {
        String gifName = gifService.getGifById(gifId).getName();

        String uri = "/gif/" + gifName;

        mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals("failure - name have to match", "cat1", gifName);
    }

    @Test
    public void testFavorites() throws Exception{
        String uri = "/favorites";

        mvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().isOk());
    }



}