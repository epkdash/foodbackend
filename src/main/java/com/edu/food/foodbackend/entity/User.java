package com.edu.food.foodbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_users")
public class User {
    @Id
    private String email;
    private String account, username, password, gender, avatar, intro;
}
