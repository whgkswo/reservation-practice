package com.springboot.counselor.repository;

import com.springboot.counselor.entity.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
    Optional<Counselor> findByUserId(String userId);
}
