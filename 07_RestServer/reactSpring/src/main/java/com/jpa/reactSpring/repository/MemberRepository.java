package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Member findByUserId(String userId);
}
