package com.gdsc.waffle.domain.repository;

import com.gdsc.waffle.domain.entity.STest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<STest, Long> {
}
