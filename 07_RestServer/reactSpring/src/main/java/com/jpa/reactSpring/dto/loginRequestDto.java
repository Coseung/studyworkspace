package com.jpa.reactSpring.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class loginRequestDto {
    private String userId;
    private String password;
}
