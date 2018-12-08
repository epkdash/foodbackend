package com.edu.food.foodbackend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user_menu")
public class UserMenu {
    @Id
    private Integer id;
    private Integer menuId;
    private String account;
}
