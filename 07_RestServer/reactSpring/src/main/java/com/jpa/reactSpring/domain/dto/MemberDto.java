package com.jpa.reactSpring.domain.dto;


import lombok.*;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemberResponseDto {
        private Long id;
        private String userId;
        private String name;
        private String githubUsername;
        private String token;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class loginRequestDto {
        @NotBlank(message = "아이디는 필수입니다")
        private String userId;
        @NotBlank(message = "비밀번호는 필수입니다")
        private String password;
    }
}
