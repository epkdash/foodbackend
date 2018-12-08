package com.edu.food.foodbackend.repository;

import com.edu.food.foodbackend.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {
    @Query(value = "SELECT * FROM t_user_comment t where t.menu_id = ?1", nativeQuery = true)
    List<UserComment> findCommentsByMenuId(Integer menuId);

    @Query(value = "SELECT * FROM t_user_comment t where t.account = ?1", nativeQuery = true)
    List<UserComment> findCommentsByAccount(String account);

    @Query(value = "insert t_user_comment(menu_id, account, comment, update_time) values(?1, ?2, ?3, ?4)", nativeQuery = true)
    void saveComment(Integer menuId, String account, String comment, Date updateTime);
}
