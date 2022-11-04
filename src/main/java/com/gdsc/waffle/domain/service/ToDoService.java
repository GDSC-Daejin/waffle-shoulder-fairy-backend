package com.gdsc.waffle.domain.service;

import com.gdsc.waffle.domain.dto.CategoryDto;
import com.gdsc.waffle.domain.dto.ToDoDto;
import com.gdsc.waffle.domain.entity.CategoryEntity;
import com.gdsc.waffle.domain.entity.ToDo;
import com.gdsc.waffle.domain.repository.CategoryRepository;
import com.gdsc.waffle.domain.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional
    public List<ToDoDto> toDoList(Long categoryId) {
        List<ToDo> toDoList = toDoRepository.findByCategoryId(categoryId);
        List<ToDoDto> dtos = new ArrayList<>();
        for (ToDo todo : toDoList) {
            ToDoDto dto = ToDoDto.createToDoDto(todo);
            dtos.add(dto);

        }
        return dtos;
    }

    @Transactional
    public ToDoDto create(Long categoryId, ToDoDto dto) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("TODO 생성실패 대상 카테고리가 없습니다."));
        ToDo todo = ToDo.createToDo(dto, category);
        ToDo create = toDoRepository.save(todo);
        return ToDoDto.createToDoDto(create);
    }

    @Transactional
    public ToDoDto update(Long id, ToDoDto dto) {
        ToDo target = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("todo 수정 실패! 대상 todo가 없습니다."));
        target.patch(dto);
        ToDo updated = toDoRepository.save(target);
        return ToDoDto.createToDoDto(updated);
    }
    @Transactional
    public ToDoDto delete(Long id)  {
        ToDo target = toDoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("todo 삭제 실패! 대상 todo이 없습니다."));
        toDoRepository.delete(target);
        return ToDoDto.createToDoDto(target);
    }
}
