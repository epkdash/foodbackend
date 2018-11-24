package com.edu.food.foodbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_menus")
public class Menu {
    @Id
    private Integer id;
    private String title, tags, imtro, ingredients, burden, albums, steps, type;
}
