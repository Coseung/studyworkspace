package com.jpa.reactSpring.service;

import com.jpa.reactSpring.entity.Member;
import org.springframework.stereotype.Service;


public interface MemberService {
     Member signup(Member member);
}
