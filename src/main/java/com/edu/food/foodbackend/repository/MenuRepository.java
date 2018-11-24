package com.edu.food.foodbackend.repository;

import com.edu.food.foodbackend.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByType(String type);

    List<Menu> findByTitle(String title);

    @Query(value = "SELECT * FROM t_menus ORDER BY RAND() limit ?1", nativeQuery = true)
    List<Menu> findRandomMenus(Integer limit);
}
