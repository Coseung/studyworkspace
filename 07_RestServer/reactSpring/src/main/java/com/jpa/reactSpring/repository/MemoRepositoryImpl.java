package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.entity.Memo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemoRepositoryImpl implements MemoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Memo save(Memo memo) {
        if (memo.getId() == null) {
            em.persist(memo);
            return memo;
        } else {
            return em.merge(memo);
        }
    }

    @Override
    public Optional<Memo> findById(Long id) {
        Memo memo = em.find(Memo.class, id);
        return Optional.ofNullable(memo);
    }

    @Override
    public void delete(Memo memo) {
        em.remove(memo);
    }

    @Override
    public List<Memo> findAllByMemberId(Long memberId) {
        return em.createQuery("select m from Memo m join fetch m.member where m.member.id = :memberId", Memo.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<Memo> findAllByPushIdAndMemberId(String pushId, Long memberId) {
        return em
                .createQuery(
                        "select m from Memo m join fetch m.member where m.pushId = :pushId and m.member.id = :memberId",
                        Memo.class)
                .setParameter("pushId", pushId)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<String> findDistinctRepoNamesByMemberId(Long memberId) {
        return em.createQuery(
                "SELECT DISTINCT m.repoName FROM Memo m WHERE m.member.id = :memberId AND m.repoName IS NOT NULL",
                String.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public List<Memo> findAllByMemberIdAndRepoName(Long memberId, String repoName) {
        return em.createQuery(
                "select m from Memo m join fetch m.member where m.member.id = :memberId and m.repoName = :repoName",
                Memo.class)
                .setParameter("memberId", memberId)
                .setParameter("repoName", repoName)
                .getResultList();
    }
}
