package com.edu.food.foodbackend.tdo;

import com.alibaba.fastjson.JSON;
import com.edu.food.foodbackend.entity.Menu;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class MenuDto {
    public static MenuDto wrapper(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(menu.getId());
        menuDto.setTitle(menu.getTitle());
        menuDto.setTags(JSON.parseArray(menu.getTags()));
        menuDto.setImtro(menu.getImtro());
        menuDto.setIngredients(menu.getIngredients());
        menuDto.setBurden(menu.getBurden());
        menuDto.setAlbums(menu.getAlbums());
        menuDto.setSteps(JSON.parseArray(menu.getSteps()));
        menuDto.setType(menu.getType());
        return menuDto;
    }

    private Integer id;
    private String title, imtro, ingredients, burden, albums, type;
    private List tags, steps;
}
