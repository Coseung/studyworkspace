package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemberResponseDto;
import com.jpa.reactSpring.dto.loginRequestDto;
import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public Member signup(Member member) {
        log.info("signup", member);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    @Override
    public MemberResponseDto login(loginRequestDto member) {
        Member loginMember = memberRepository.findByUserId(member.getUserId());
        log.info("login", loginMember);

        if (loginMember != null && loginMember.getPassword().equals(member.getPassword())) {
            return MemberResponseDto.builder()
                    .id(loginMember.getId())
                    .userId(loginMember.getUserId())
                    .name(loginMember.getName())
                    .githubUsername(loginMember.getGithubUsername())
                    .build();
        }
        return null;
    }
}
