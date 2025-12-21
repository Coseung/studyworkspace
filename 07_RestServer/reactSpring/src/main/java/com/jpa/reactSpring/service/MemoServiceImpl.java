package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemoDto;
import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.entity.Memo;
import com.jpa.reactSpring.repository.MemberRepository;
import com.jpa.reactSpring.repository.MemoRepository;
import com.jpa.reactSpring.repository.TagRepository;
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
    private final TagRepository tagRepository;

    @Override
    public List<Memo> getMemos(Long memberId) {
        log.info("getMemos : {}", memberId);
        return memoRepository.findAllByMemberId(memberId);
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

    @Override
    public List<MemoDto.MemoTagListByMemberIdDto> getTags(Long memberId) {


        return tagRepository.findTagByMemberId(memberId)
                .stream()
                .map(tag -> MemoDto.MemoTagListByMemberIdDto.of(
                        tag.getId(),
                        tag.getName())
                ).toList();
    }

//    @Override
//    public List<Memo> getMemosByPushId(String pushId, Long memberId) {
//        log.info("getMemosByPushId {}", pushId);
//        return memoRepository.findAllByPushIdAndMemberId(pushId, memberId);
//    }
}
