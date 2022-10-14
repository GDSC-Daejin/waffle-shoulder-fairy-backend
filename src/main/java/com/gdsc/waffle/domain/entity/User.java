package com.gdsc.waffle.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    static Long id;

    @Column
    static String email;

    @Column
    static String password;

    @Column
    static String nickname;

    @Column
    static Boolean withdraw;


}

