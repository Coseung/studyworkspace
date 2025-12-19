package com.jpa.reactSpring.service;

import com.jpa.reactSpring.dto.MemberResponseDto;
import com.jpa.reactSpring.dto.loginRequestDto;
import com.jpa.reactSpring.entity.Member;

public interface MemberService {
     Member signup(Member member);

     MemberResponseDto login(loginRequestDto member);
}
