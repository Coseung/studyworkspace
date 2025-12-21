package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemberDto;
import com.jpa.reactSpring.entity.Member;

public interface MemberService {
     Long signup(Member member);

     MemberDto.MemberResponseDto login(MemberDto.loginRequestDto member);
}
