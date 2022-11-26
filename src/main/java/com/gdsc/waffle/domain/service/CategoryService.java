package com.gdsc.waffle.domain.service;

import com.gdsc.waffle.domain.dto.CategoryDto;
import com.gdsc.waffle.domain.entity.CategoryEntity;
import com.gdsc.waffle.domain.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class CategoryService {
    @Autowired //DI
    private CategoryRepository categoryRepository;
    public List<CategoryEntity> index(){
        return categoryRepository.findAll();
    }

    public CategoryEntity show(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public CategoryEntity create(CategoryDto dto) {
        CategoryEntity category= dto.toEntity();
        if(category.getId() != null){
            return null;
        }
        return categoryRepository.save(category);
    }

    @Transactional
    public CategoryEntity update(Long id, CategoryDto dto) {
        //1.엔티티 생성
        CategoryEntity categoryEntity= dto.toEntity();
        log.info("id: {} , 카테고리: {}", id, categoryEntity.toString());

        //2. 대상 엔티티를 조회
        CategoryEntity target = categoryRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리
        if(target ==null || !id.equals(categoryEntity.getId())){
            //400 잘목된 요청응답
            log.info("잘못된 요청 id: {}, 카테고리: {}", id, categoryEntity.toString());
            return null;
        }
        //4. 업데이트 및 정상응답(200)
        if(!target.patch(categoryEntity)){
            log.info("request info null exception");
            return null;
        }
        return categoryRepository.save(target);
    }

    @Transactional
    public CategoryEntity delete(Long id) {
        CategoryEntity target =  categoryRepository.findById(id).orElse(null);
        categoryRepository.delete(Objects.requireNonNull(target));
        return target;
    }
}
