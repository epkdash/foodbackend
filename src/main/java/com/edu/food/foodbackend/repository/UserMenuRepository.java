package com.edu.food.foodbackend.repository;

import com.edu.food.foodbackend.entity.Menu;
import com.edu.food.foodbackend.entity.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMenuRepository extends JpaRepository<UserMenu, Integer> {
    @Query(value = "SELECT * FROM t_user_menu t where t.account = ?1", nativeQuery = true)
    List<UserMenu> findRelations(String account);

    @Query(value = "SELECT * FROM t_user_menu t where t.account = ?1 and t.menu_id = ?2", nativeQuery = true)
    UserMenu findRelation(String account, Integer menuId);

    @Query(value = "insert t_user_menu(menu_id, account) values(?1, ?2)", nativeQuery = true)
    void saveRelation(Integer menuId, String account);
}
