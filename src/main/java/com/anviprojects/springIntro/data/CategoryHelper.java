package com.anviprojects.springIntro.data;

import com.anviprojects.springIntro.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryHelper {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Pushin Eats"),
            new Category(2, "Pushin Plays"),
            new Category(3, "Other stuff")
    );

    public  List<Category> getAllCategories(){
        return ALL_CATEGORIES;
    }

}
