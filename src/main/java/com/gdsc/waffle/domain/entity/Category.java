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
@Entity // 테이블 자동 생성을 위한 목적 다른건 JDBC 쓰세요 !!!!!!!
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(nullable = false, length = 15)
    private String category;

}
