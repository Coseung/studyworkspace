package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.dto.MemoDto;
import com.jpa.reactSpring.entity.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Tag> findTagByMemberId(Long memberId) {

        String hql = "select distinct mt.tag from MemoTag mt join mt.memo m where m.member.id = :memberId";
        return em.createQuery(hql, Tag.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
