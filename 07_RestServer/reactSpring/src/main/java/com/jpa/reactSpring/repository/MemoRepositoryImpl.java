package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.entity.Memo;

import java.util.List;

public class MemoRepositoryImpl implements MemoRepository {
    @Override
    public List<Memo> findAllByMemberId(Long memberId) {
        return List.of();
    }

    @Override
    public List<Memo> findAllByPushIdAndMemberId(String pushId, Long memberId) {
        return List.of();
    }
}
