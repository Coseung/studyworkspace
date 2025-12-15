package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemoRequestDto;
import com.jpa.reactSpring.entity.Memo;

import java.util.List;

public interface MemoService {
    List<Memo> getMemos(Long memberId);
    Memo addMemo(MemoRequestDto dto);
    Memo updateMemo(Long id, String memoText, Long memberId);
    void deleteMemo(Long id, Long memberId);
    List<Memo> getMemosByPushId(String pushId, Long memberId);
}
