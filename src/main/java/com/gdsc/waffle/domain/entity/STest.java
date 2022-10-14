package com.gdsc.waffle.domain.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
@Entity
public class STest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String testText;
}


