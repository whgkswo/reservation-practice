package com.springboot.counselor.repository;

import com.springboot.counselor.entity.Counselor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselorRepository extends JpaRepository<Counselor, Long> {
}
