package com.gdsc.waffle.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String category;


    public boolean patch(CategoryEntity categoryEntity) {
        if(categoryEntity.category != null){
            this.category=categoryEntity.category;
            return true;
        }
        return false;
    }
}
