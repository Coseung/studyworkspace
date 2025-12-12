package com.jpa.reactSpring.service;

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
        log.info("MemberServiceImpl::signup", member);
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }
}
