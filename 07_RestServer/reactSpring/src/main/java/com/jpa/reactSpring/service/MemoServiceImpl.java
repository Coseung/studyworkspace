package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemoRequestDto;
import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.entity.Memo;
import com.jpa.reactSpring.repository.MemberRepository;
import com.jpa.reactSpring.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Memo> getMemos(Long memberId) {

        return memoRepository.findAllByMemberId(memberId);
    }

    @Override
    @Transactional
    public Memo addMemo(MemoRequestDto dto) {
        log.info("MemoServiceImpl::addMemo", dto);

        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("멤버가 없음요"));

        Memo memo = Memo.createMemo(
                dto.getPushId(),
                dto.getPushDate(),
                dto.getRepoName(),
                dto.getBranch(),
                dto.getMemo(),
                member
        );

        return memoRepository.save(memo);
    }

    @Override
    @Transactional
    public Memo updateMemo(Long id, String memoText, Long memberId) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메모가 없음"));

        if (!memo.getMember().getId().equals(memberId)) {
            throw new IllegalArgumentException("너 메모 아님");
        }

        memo.setMemo(memoText);
        return memo;
    }

    @Override
    @Transactional
    public void deleteMemo(Long id, Long memberId) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("지울 메모가 없음"));
        if (!memo.getMember().getId().equals(memberId)) {
            throw new IllegalArgumentException("니꺼만 지워라");
        }
        memoRepository.delete(memo);
    }

    @Override
    public List<Memo> getMemosByPushId(String pushId, Long memberId) {
        return memoRepository.findAllByPushIdAndMemberId(pushId, memberId);
    }
}
