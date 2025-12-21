package com.jpa.reactSpring.dto;

import com.jpa.reactSpring.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class MemoDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemoRequestDto {
        private String pushId;
        private String pushDate;
        private String repoName;
        private String branch;
        private String memo;
        private Long memberId;

//        public Memo toEntity(String pushId, String pushDate, String repoName, String branch, String memo) {
//            return Memo.builder()
//                    .pushId(pushId)
//                    .pushDate(pushDate)
//                    .repoName(repoName)
//                    .branch(branch)
//                    .memo(memo)
//                    .build();
//        }
        public Memo toEntity() {
            return Memo.builder()
                    .pushId(pushId)
                    .pushDate(pushDate)
                    .repoName(repoName)
                    .branch(branch)
                    .memo(memo)
                    .build();
        }
    }
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemoTagListByMemberIdDto{
        private String tagName;

        public static MemoTagListByMemberIdDto of(String tagName) {
            return MemoTagListByMemberIdDto.builder()
                    .tagName(tagName)
                    .build();
        }
    }
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class MemoResponseDto {
        private String pushId;
        private String pushDate;
        private String repoName;
        private String branch;
        private String memo;
        private Long memberId;

        public static MemoResponseDto of(String pushId, String pushDate, String repoName, String branch, String memo, Long id) {
            return MemoResponseDto.builder()
                    .pushId(pushId)
                    .pushDate(pushDate)
                    .repoName(repoName)
                    .branch(branch)
                    .memo(memo)
                    .memberId(id)
                    .build();
        }
    }


}
