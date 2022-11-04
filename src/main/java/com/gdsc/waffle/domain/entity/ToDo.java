package com.gdsc.waffle.domain.entity;

import lombok.*;

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
    private LocalDate dateCreated;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    @Column(name = "date_target")
    private LocalDate dateTarget;

    @Column
    private Boolean status;

    @Column
    private Boolean deleted;



    @ManyToOne
    @JoinColumn (name = "category_id")
    private CategoryEntity categoryId;

}
