package com.gdsc.waffle.domain.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    @Test
    public void InsertDummies(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .email("email..." + i)
                    .password("Password..." +i)
                    .nickname("name."+ i)
                    .dateCreated(LocalDate.of(2022,10,14))
                    .withdraw(false)
                    .build();
            //Create!
            userRepository.save(user);
        });
    }


}