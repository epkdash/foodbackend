package com.edu.food.foodbackend.controller;

import com.edu.food.foodbackend.entity.UserMenu;
import com.edu.food.foodbackend.repository.UserMenuRepository;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserMenuController {
    @Autowired
    public UserMenuRepository userMenuRepository;

    @RequestMapping(value = "/relation/{account}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserMenu> getRelationByAct(
            @ApiParam(value = "account", required = true) @PathVariable String account) {
        return userMenuRepository.findRelations(account);
    }

    @RequestMapping(value = "/relation/{account}/{menuId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public UserMenu getRelationByAct(
            @ApiParam(value = "account", required = true) @PathVariable String account,
            @ApiParam(value = "menuId", required = true) @PathVariable Integer menuId) {
        return userMenuRepository.findRelation(account, menuId);
    }

    @RequestMapping(value = "/relation/{account}/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addRelation(
            @ApiParam(value = "account", required = true) @PathVariable String account,
            @ApiParam(value = "menuId", required = true) @PathVariable Integer menuId) {
        userMenuRepository.saveRelation(menuId, account);
    }
}
