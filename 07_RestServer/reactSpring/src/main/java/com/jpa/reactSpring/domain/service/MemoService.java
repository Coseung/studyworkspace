package com.jpa.reactSpring.domain.service;

import com.jpa.reactSpring.domain.dto.MemoDto;
import com.jpa.reactSpring.domain.entity.Memo;

import java.util.List;

public interface MemoService {
    List<Memo> getMemos(Long memberId);

    Memo addMemo(MemoDto.MemoRequestDto dto);

    Memo updateMemo(Long id, String memoText, Long memberId);

    void deleteMemo(Long id, Long memberId);

    List<MemoDto.MemoTagListByMemberIdDto> getTags(Long memberId);

    List<MemoDto.MemoResponseDto> getMemosByTag(Long memberId, String tag);
    // List<Memo> getMemosByPushId(String pushId, Long memberId);
}
