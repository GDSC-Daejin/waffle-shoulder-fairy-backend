package com.gdsc.waffle.domain.repository;

import com.gdsc.waffle.domain.entity.STest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestRepositoryTest {
    @Autowired
    TestRepository testRepository;

    @Test
    public void InsertDummies(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
             STest test = STest.builder()
                    .testText("Sample..." + i)
                    .build();
            //Create!
            testRepository.save(test);
        });
    }

}