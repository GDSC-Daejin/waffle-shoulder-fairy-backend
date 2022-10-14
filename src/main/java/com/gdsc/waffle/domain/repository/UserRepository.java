package com.gdsc.waffle.domain.repository;

import com.gdsc.waffle.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
