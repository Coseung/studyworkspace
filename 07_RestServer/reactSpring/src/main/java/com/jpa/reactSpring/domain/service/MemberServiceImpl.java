package com.jpa.reactSpring.domain.service;

import com.jpa.reactSpring.domain.dto.MemberDto;

import com.jpa.reactSpring.domain.entity.Member;
import com.jpa.reactSpring.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public Long signup(Member member) {
        log.info("signup", member);
        memberRepository.save(member);

        return member.getId();
    }

    @Override
    public MemberDto.MemberResponseDto login(MemberDto.loginRequestDto member) {
        Member loginMember = memberRepository.findByUserId(member.getUserId());


        log.info("login", loginMember);
        if (loginMember == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }


        if (!loginMember.getPassword().equals(member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }


        if (loginMember != null && loginMember.getPassword().equals(member.getPassword())) {
            return MemberDto.MemberResponseDto.builder()
                    .id(loginMember.getId())
                    .userId(loginMember.getUserId())
                    .name(loginMember.getName())
                    .githubUsername(loginMember.getGithubUsername())
                    .token(token)
                    .build();
        }
        return null;
    }
}
