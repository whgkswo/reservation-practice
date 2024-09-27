package com.springboot.member.repository;


import com.springboot.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository {
    Optional<Member> findByMemberId(long memberId);
}
