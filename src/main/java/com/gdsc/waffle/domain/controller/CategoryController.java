package com.gdsc.waffle.domain.controller;

import com.gdsc.waffle.domain.dto.CategoryDto;
import com.gdsc.waffle.domain.entity.CategoryEntity;
import com.gdsc.waffle.domain.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @Autowired
    private CategoryService categoryService;

    //목록
    @GetMapping
    public List<CategoryEntity> index(){
        System.out.println("성공1");
        return categoryService.index();
    }

    @GetMapping("/{id}")
    public CategoryEntity show(@PathVariable Long id){
        System.out.println("성공2");
        return categoryService.show(id);
    }
    //카태고리 생성
    @PostMapping
    public ResponseEntity<CategoryEntity> create(@RequestBody CategoryDto dto){
        //서비스에게 넘겨줌
        CategoryEntity created = categoryService.create(dto);
        System.out.println("성공");
        return (created != null ) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //카태고리 수정
    @PatchMapping("/{id}")
    public ResponseEntity<CategoryEntity> update(@PathVariable Long id,
                                                 @RequestBody CategoryDto dto){
        CategoryEntity updated = categoryService.update(id,dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //카태고리  삭제
    @DeleteMapping("/{id}")
    public ResponseEntity <CategoryEntity> delete(@PathVariable Long id){
        CategoryEntity deleted = categoryService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
