package com.jpa.reactSpring.domain.repository;

import com.jpa.reactSpring.domain.entity.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);

    Optional<Memo> findById(Long id);

    void delete(Memo memo);

    List<Memo> findAllByMemberId(Long memberId);


    List<Memo> findAllByPushIdAndMemberId(String pushId, Long memberId);

    List<String> findDistinctRepoNamesByMemberId(Long memberId);

    List<Memo> findAllByMemberIdAndRepoName(Long memberId, String repoName);

}
