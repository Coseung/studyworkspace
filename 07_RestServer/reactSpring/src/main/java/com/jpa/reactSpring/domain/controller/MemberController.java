package com.jpa.reactSpring.domain.controller;

import com.jpa.reactSpring.domain.dto.MemberDto;
import com.jpa.reactSpring.domain.entity.Member;
import com.jpa.reactSpring.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 유저 수정, 목록 등 기능 추가 예정

    @PostMapping("/signup")
    public Long signup(@RequestBody Member member) {

        return memberService.signup(member);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDto.MemberResponseDto> login(@RequestBody MemberDto.loginRequestDto member) {
        log.info("member : {}", member.getUserId());
        MemberDto.MemberResponseDto responseDto = memberService.login(member);

        if (responseDto != null) {
            log.info("Login Success: {}", responseDto.getUserId());

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

