package com.edu.food.foodbackend.tdo;

import com.alibaba.fastjson.JSON;
import com.edu.food.foodbackend.entity.Menu;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
public class MenuTdo {
    public static MenuTdo wrapper(Menu menu) {
        MenuTdo menuTdo = new MenuTdo();
        menuTdo.setId(menu.getId());
        menuTdo.setTitle(menu.getTitle());
        menuTdo.setTags(JSON.parseArray(menu.getTags()));
        menuTdo.setImtro(menu.getImtro());
        menuTdo.setIngredients(menu.getIngredients());
        menuTdo.setBurden(menu.getBurden());
        menuTdo.setAlbums(menu.getAlbums());
        menuTdo.setSteps(JSON.parseArray(menu.getSteps()));
        menuTdo.setType(menu.getType());
        return menuTdo;
    }

    @Id
    private Integer id;
    private String title, imtro, ingredients, burden, albums, type;
    private List tags, steps;
}
