package com.jpa.reactSpring.domain.service;

import com.jpa.reactSpring.domain.dto.MemoDto;
import com.jpa.reactSpring.domain.entity.Member;
import com.jpa.reactSpring.domain.entity.Memo;
import com.jpa.reactSpring.domain.repository.MemberRepository;
import com.jpa.reactSpring.domain.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Memo> getMemos(Long memberId) {
        log.info("getMemos : {}", memberId);
        return memoRepository.findAllByMemberId(memberId);
    }

    @Override
    public List<MemoDto.MemoTagListByMemberIdDto> getTags(Long memberId) {
        log.info("getTags : {}", memberId);
        List<String> repoNames = memoRepository.findDistinctRepoNamesByMemberId(memberId);

        return repoNames.stream()
                .map(repoName -> MemoDto.MemoTagListByMemberIdDto.of(repoName))
                .toList();
    }

    @Override
    public List<MemoDto.MemoResponseDto> getMemosByTag(Long memberId, String tag) {
        log.info("getMemosByTag : {}, tag : {}", memberId, tag);
        return memoRepository.findAllByMemberIdAndRepoName(memberId, tag)
                .stream()
                .map(memo -> MemoDto.MemoResponseDto.of(
                        memo.getPushId(),
                        memo.getPushDate(),
                        memo.getRepoName(),
                        memo.getBranch(),
                        memo.getMemo(),
                        memo.getMember().getId()
                ))
                .toList();
    }

    @Override
    @Transactional
    public Memo addMemo(MemoDto.MemoRequestDto dto) {
        log.info("MemoServiceImpl::addMemo {}", dto.getMemberId());

        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("멤버가 없음요"));

        Memo memo = dto.toEntity();
        memo.changeMember(member);
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

        memo.changeMemo(memoText);
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

    // deleted duplicate getTags

    // @Override
    // public List<Memo> getMemosByPushId(String pushId, Long memberId) {
    // log.info("getMemosByPushId {}", pushId);
    // return memoRepository.findAllByPushIdAndMemberId(pushId, memberId);
    // }
}
