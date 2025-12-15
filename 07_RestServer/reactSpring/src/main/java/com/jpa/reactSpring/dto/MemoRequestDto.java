package com.jpa.reactSpring.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class MemoRequestDto {
    private String pushId;
    private String pushDate;
    private String repoName;
    private String branch;
    private String memo;
    private Long memberId;
}
