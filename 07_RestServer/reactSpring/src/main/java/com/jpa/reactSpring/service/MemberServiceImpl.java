package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemberDto;

import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.repository.MemberRepository;
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

        if (loginMember != null && loginMember.getPassword().equals(member.getPassword())) {
            return MemberDto.MemberResponseDto.builder()
                    .id(loginMember.getId())
                    .userId(loginMember.getUserId())
                    .name(loginMember.getName())
                    .githubUsername(loginMember.getGithubUsername())
                    .build();
        }
        return null;
    }
}
