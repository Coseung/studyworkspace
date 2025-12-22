package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Member member) {em.persist(member);}

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    //jpql활요
    @Override
    public Member findByUserId(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
        List<Member> result = em.createQuery(jpql, Member.class)
                .setParameter("userId", userId)
                .getResultList();

        return result.stream().findFirst().orElse(null);
    }
    
}
