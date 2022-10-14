package com.gdsc.waffle.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    @Column(nullable = false)
    private String content;
    @Column
    private String memo;

    // 최초 생성날짜
    // 최종 수정날짜
    // 목표 달성날짜
    @Column
    private Boolean status;

    @Column
    private Boolean deleted;


}
