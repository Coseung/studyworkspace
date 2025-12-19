package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.entity.Memo;

import java.util.List;
import java.util.Optional;

public interface MemoRepository {
    Memo save(Memo memo);

    Optional<Memo> findById(Long id);

    void delete(Memo memo);

    // 멤버 아이디로 메모 싹 다 긁어오기
    List<Memo> findAllByMemberId(Long memberId);

    // 푸시 아이디랑 멤버 아이디로 조회 (혹시 몰라서 멤버 아이디도 같이 조건 검사)
    List<Memo> findAllByPushIdAndMemberId(String pushId, Long memberId);
}
