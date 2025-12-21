package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemoDto;
import com.jpa.reactSpring.entity.Memo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemoService {
    List<Memo> getMemos(Long memberId);
    Memo addMemo(MemoDto.MemoRequestDto dto);
    Memo updateMemo(Long id, String memoText, Long memberId);
    void deleteMemo(Long id, Long memberId);

    List<MemoDto.MemoTagListByMemberIdDto> getTags(Long memberId);
//    List<Memo> getMemosByPushId(String pushId, Long memberId);
}
