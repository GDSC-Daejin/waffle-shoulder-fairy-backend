package com.gdsc.waffle.domain.controller;

import com.gdsc.waffle.domain.entity.User;
import com.gdsc.waffle.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/get")
    public String getTest(){
        return "success";
    }



}
