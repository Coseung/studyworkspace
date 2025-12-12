package com.jpa.reactSpring.controller;


import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) {

        return memberService.signup(member);
    }

}
