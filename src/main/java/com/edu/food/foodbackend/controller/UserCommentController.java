package com.edu.food.foodbackend.controller;

import com.edu.food.foodbackend.entity.UserComment;
import com.edu.food.foodbackend.entity.UserMenu;
import com.edu.food.foodbackend.repository.UserCommentRepository;
import com.edu.food.foodbackend.repository.UserMenuRepository;
import com.edu.food.foodbackend.tdo.UserCommentDto;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserCommentController {
    @Autowired
    public UserCommentRepository userCommentRepository;

    @RequestMapping(value = "/comment/menuId/{menuId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserCommentDto> findCommentsByMenuId(
            @ApiParam(value = "menuId", required = true) @PathVariable Integer menuId) {
        return userCommentRepository.findCommentsByMenuId(menuId).stream().map(userComment ->
                UserCommentDto.wrapper(userComment)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/comment/account/{account}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserCommentDto> findCommentsByAccount(
            @ApiParam(value = "account", required = true) @PathVariable String account) {
        return userCommentRepository.findCommentsByAccount(account).stream().map(userComment ->
                UserCommentDto.wrapper(userComment)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/comment/{account}/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(
            @ApiParam(value = "account", required = true) @PathVariable String account,
            @ApiParam(value = "menuId", required = true) @PathVariable Integer menuId,
            @ApiParam(value = "comment", required = true) @RequestBody String comment) throws UnsupportedEncodingException {
        String chineseComment = URLDecoder.decode(comment, "utf-8");
        userCommentRepository.saveComment(menuId, account, chineseComment, new Date());
    }
}
