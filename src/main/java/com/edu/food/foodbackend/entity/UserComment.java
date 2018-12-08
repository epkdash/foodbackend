package com.edu.food.foodbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user_comment")
public class UserComment {
    @Id
    private Integer id;
    private Integer menuId;
    private String account;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
