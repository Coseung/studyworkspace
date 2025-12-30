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

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class loginRequestDto {
        private String userId;
        private String password;
    }
}
