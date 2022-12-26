package com.gdsc.waffle.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gdsc.waffle.domain.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ToDoDto {
    private  Long id;
    private String content;
    private String memo;
    //private LocalDate dateCreated;
    //private LocalDate lastUpdate;
    //private LocalDate dateTarget;
    private Boolean IsChecked;
    //private Boolean deleted;

    @JsonProperty
    private Long categoryId;

    public static ToDoDto createToDoDto(ToDo todo) {
        return new ToDoDto(
                todo.getId(),
                todo.getContent(),
                todo.getMemo(),
                //todo.getDateCreated(),
                //todo.getLastUpdate(),
                //todo.getDateTarget(),
                todo.getIsChecked(),
                //todo.getDeleted(),
                todo.getCategory().getId()
        );
    }

}
