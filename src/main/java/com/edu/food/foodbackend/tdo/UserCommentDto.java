package com.edu.food.foodbackend.tdo;

import com.alibaba.fastjson.JSON;
import com.edu.food.foodbackend.entity.Menu;
import com.edu.food.foodbackend.entity.UserComment;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class UserCommentDto {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static UserCommentDto wrapper(UserComment userComment) {
        UserCommentDto userCommentDto = new UserCommentDto();
        userCommentDto.setAccount(userComment.getAccount());
        userCommentDto.setComment(userComment.getComment());
        userCommentDto.setId(userComment.getId());
        userCommentDto.setMenuId(userComment.getMenuId());
        userCommentDto.setUpdateTime(sdf.format(userComment.getUpdateTime()));
        return userCommentDto;
    }

    private Integer id;
    private Integer menuId;
    private String account;
    private String comment;
    private String updateTime;
}
