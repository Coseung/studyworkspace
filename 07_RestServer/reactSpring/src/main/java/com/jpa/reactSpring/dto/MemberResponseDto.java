package com.jpa.reactSpring.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private Long id;
    private String userId;
    private String name;
    private String githubUsername;
}
