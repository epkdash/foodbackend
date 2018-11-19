package com.edu.food.foodbackend.controller;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/")
public class FoodController {

    @RequestMapping(value = "/foods", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getFoods() {
        return "1";
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getFoodById(
            @ApiParam(value = "id", required = true) @PathVariable Integer id) {
        return "2";
    }


}
