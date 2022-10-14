package com.gdsc.waffle.domain.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String memo;

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "YYYY-MM-dd-HH:mm:ss")
    private LocalDate dateCreated;

    @Column(name = "last_update")
    @DateTimeFormat(pattern = "YYYY-MM-dd-HH:mm:ss")
    private LocalDate lastUpdare;

    @Column(name = "date_target")
    @DateTimeFormat(pattern = "YYYY-MM-dd-HH:mm:ss")
    private LocalDate dateTarget;

    @Column
    private Boolean status;

    @Column
    private Boolean deleted;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category categoryId;

}
