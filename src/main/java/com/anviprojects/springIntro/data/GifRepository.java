package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Gif;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface GifRepository  extends CrudRepository<Gif, Integer>{

}
