package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class GifRepositoryTest {

    private GifRepository gifRepository;

    @Autowired
    public void setGifRepository(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @Test
    public void testSaveGif(){
        Gif gif = new Gif();
        gif.setCategoryId(1);
        gif.setDateUploaded(LocalDate.of(2016,5,7));
        gif.setName("cat1");
        gif.setUsername("Anvi");
        gif.setFavorite(false);

        assertNull(gif.getId());
        gifRepository.save(gif);
        assertNotNull(gif.getId());
    }


}