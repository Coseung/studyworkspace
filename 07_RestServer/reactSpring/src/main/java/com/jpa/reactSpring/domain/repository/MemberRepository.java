package com.jpa.reactSpring.domain.repository;

import com.jpa.reactSpring.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);

    Optional<Member> findById(Long id);

    Member findByUserId(String userId);
}
