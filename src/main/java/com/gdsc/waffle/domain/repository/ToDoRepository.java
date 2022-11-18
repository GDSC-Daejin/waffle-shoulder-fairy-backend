package com.gdsc.waffle.domain.repository;

import com.gdsc.waffle.domain.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    @Query(value =
            "SELECT * " +
                    "FROM todo " +
                    "WHERE category_id = :categoryId",
            nativeQuery = true)
    List<ToDo> findByCategoryId(Long categoryId);

}
