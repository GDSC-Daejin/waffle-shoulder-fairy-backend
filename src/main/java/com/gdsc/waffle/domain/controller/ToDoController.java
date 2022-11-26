package com.gdsc.waffle.domain.controller;

import com.gdsc.waffle.domain.dto.ToDoDto;
import com.gdsc.waffle.domain.service.ToDoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/category")
public class ToDoController {
    @Autowired
    private ToDoService todoService;
    // todo 목록 조회
    @GetMapping("/{categoryId}/todo")
    public ResponseEntity<List<ToDoDto>> todos(@PathVariable Long categoryId){
        //서비스에게 위임
        List<ToDoDto> dtos = todoService.toDoList(categoryId);

        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    // todo 생성
    @PostMapping("/{categoryId}/todo")
    public ResponseEntity<ToDoDto> create(@PathVariable Long categoryId,
                                             @RequestBody ToDoDto dto){
        //서비스에게 위임
        ToDoDto createDto = todoService.create(categoryId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createDto);
    }
    //todo글 수정
    @PatchMapping("/todos/{id}")
    public ResponseEntity<ToDoDto> update(@PathVariable Long id,
                                             @RequestBody ToDoDto dto) {
        // 서비스에게 위임
        ToDoDto updatedDto = todoService.update(id, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    //todo 삭제
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ToDoDto> delete(@PathVariable Long id){
        // 서비스에게 위임
        ToDoDto deleteDto = todoService.delete(id);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
    }
}



