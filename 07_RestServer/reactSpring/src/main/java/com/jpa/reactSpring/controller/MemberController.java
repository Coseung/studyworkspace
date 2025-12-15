package com.jpa.reactSpring.controller;


import com.jpa.reactSpring.dto.MemberResponseDto;
import com.jpa.reactSpring.dto.loginRequestDto;
import com.jpa.reactSpring.entity.Member;
import com.jpa.reactSpring.service.MemberService;
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
    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) {

        return memberService.signup(member);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto> login(@RequestBody loginRequestDto member) {
        log.info("member : {}", member.getUserId());
        Member user = memberService.login(member);
        if(user != null) {
            if(user.getPassword().equals(member.getPassword())) {
                log.info("Login Success: {}", user.getUserId());

                MemberResponseDto responseDto = MemberResponseDto.builder()
                        .id(user.getId())
                        .userId(user.getUserId())
                        .name(user.getName())
                        .githubUsername(user.getGithubUsername())
                        .build();

                return new ResponseEntity<>(responseDto, HttpStatus.OK);

            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
