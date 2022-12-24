package com.gdsc.waffle.domain.entity;

import com.gdsc.waffle.domain.dto.ToDoDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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

    //@Column(name = "date_created")
    //private LocalDate dateCreated;

    //@Column(name = "last_update")
    //private LocalDate lastUpdate;

    @Column(name = "date_target")
    private LocalDate dateTarget;

    @Column
    @ColumnDefault("false")
    private Boolean IsChecked;

    //@Column
    //@ColumnDefault("false")
    //private Boolean deleted;




    @ManyToOne
    @JoinColumn (name = "category_id")
    private CategoryEntity category;

    public static ToDo createToDo(ToDoDto dto, CategoryEntity category) {
        //예외 처리
        if (dto.getId() != null) {
            throw new IllegalArgumentException("todo 생성 실패! 새애의 ID가 있어야 합니다.");
        }
        if (!Objects.equals(dto.getCategoryId(), category.getId())) {
            throw new IllegalArgumentException("todo 생성 실패! 카테고리의 id가 잘못되었습니다.");
        }

        //엔티티 생성 및 반환
        return new ToDo(
                dto.getId(),
                dto.getContent(),
                dto.getMemo(),
                //dto.getDateCreated(),
                //dto.getLastUpdate(),
                dto.getDateTarget(),
                dto.getIsChecked(),
                //dto.getDeleted(),
                category
        );
    }

    public void patch(ToDoDto dto) {
        // 예외 발생
        if (!Objects.equals(this.id, dto.getId()))
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");
        // 객체를 갱신
        if (dto.getContent() != null)
            this.content = dto.getContent();
        if (dto.getMemo() != null)
            this.memo = dto.getMemo();
    }
}

