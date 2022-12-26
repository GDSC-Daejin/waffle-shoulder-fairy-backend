package com.gdsc.waffle.domain.entity;

import com.sun.istack.NotNull;
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
    @Column
    private Long id;

    @Column
    @NotNull
    private String category;


    public boolean patch(CategoryEntity categoryEntity) {
        if(categoryEntity.category != null){
            this.category=categoryEntity.category;
            return true;
        }
        return false;
    }
}
