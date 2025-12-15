package com.jpa.reactSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pushId;
    private String pushDate;
    private String repoName;
    private String branch;

    @Column(columnDefinition = "TEXT")
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public static Memo createMemo(String pushId, String pushDate, String repoName, String branch, String memo, Member member) {
        Memo m = new Memo();
        m.pushId = pushId;
        m.pushDate = pushDate;
        m.repoName = repoName;
        m.branch = branch;
        m.memo = memo;
        m.member = member;
        return m;
    }
}
