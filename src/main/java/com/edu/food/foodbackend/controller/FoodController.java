package com.edu.food.foodbackend.controller;

import com.edu.food.foodbackend.entity.Menu;
import com.edu.food.foodbackend.repository.MenuRepository;
import com.edu.food.foodbackend.tdo.MenuTdo;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class FoodController {

    @Autowired
    public MenuRepository menuRepository;

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MenuTdo> getMenus() {
        return menuRepository.findAll().stream().map(menu ->
                MenuTdo.wrapper(menu)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MenuTdo getMenuById(
            @ApiParam(value = "id", required = true) @PathVariable Integer id) {
        Optional<Menu> optionalMenu = menuRepository.findById(id);
        return optionalMenu.isPresent() ? MenuTdo.wrapper(optionalMenu.get()) : new MenuTdo();
    }

    @RequestMapping(value = "/menus/type/{type}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MenuTdo> getMenuByType(
            @ApiParam(value = "type", required = true) @PathVariable String type) {
        return menuRepository.findByType(type).stream().map(menu ->
                MenuTdo.wrapper(menu)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/menus/random/limit/{limit}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MenuTdo> getRandomMenus(
            @ApiParam(value = "limit", required = true) @PathVariable Integer limit) {
        return menuRepository.findRandomMenus(limit).stream().map(menu ->
                MenuTdo.wrapper(menu)
        ).collect(Collectors.toList());
    }

    @RequestMapping(value = "/menu/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<MenuTdo> getMenuByTitle(
            @ApiParam(value = "title", required = true) @PathVariable String title) {
        return menuRepository.findByTitle(title).stream().map(menu ->
                MenuTdo.wrapper(menu)
        ).collect(Collectors.toList());
    }
}
