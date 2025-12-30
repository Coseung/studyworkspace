package com.jpa.reactSpring.domain.service;

import com.jpa.reactSpring.domain.dto.MemberDto;
import com.jpa.reactSpring.domain.entity.Member;

public interface MemberService {
     Long signup(Member member);

     MemberDto.MemberResponseDto login(MemberDto.loginRequestDto member);
}
