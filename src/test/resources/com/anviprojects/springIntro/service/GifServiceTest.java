package com.anviprojects.springIntro.service;

import com.anviprojects.springIntro.model.Gif;
import com.anviprojects.springIntro.test.AbstractTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;

/**
 *
 */
@Transactional
public class GifServiceTest extends AbstractTest {

    @Autowired
    public GifService gifService;

    private Integer gifId;

    @Before
    public void setUp(){
        Gif gif = new Gif("cat1", 1 , "Anvi", LocalDate.now(),false);
        Gif savedGif = gifService.saveGif(gif);
        gifId = savedGif.getId();
    }

    @Test
    public void testFindAll(){
        Collection<Gif> list = (Collection<Gif>) gifService.listOfGifs();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertEquals("failure - expected size", 1, list.size());

    }

    @Test
    public void testFindOne(){
        Integer id = gifId;
        Gif entity = gifService.getGifById(id);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected id attribute match", id, entity.getId());
    }

    @Test
    public void testFindOneNotFound(){
        Integer id = Integer.MAX_VALUE;
        Gif entity = gifService.getGifById(id);

        Assert.assertNull("failure - expected Null", entity);
    }

    @Test
    public void testFindByName(){
        String name = "cat1";
        Gif entity = gifService.getGifByName(name);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected name atribute match", name, entity.getName());
    }

    @Test
    public void testFindByCategory(){
        Integer id = new Integer(1);
        Collection<Gif> list = (Collection<Gif>) gifService.getGifsByCategoryId(id);

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertEquals("failure - expected size", 1, list.size());
    }
}
