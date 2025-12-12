package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "REPLY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_NO")
    private Long replyNo;

    @Column(name = "REPLY_CONTENT", nullable = false, length = 400)
    private String replyContent;

    @Column(name = "REF_BNO", nullable = false)
    private Long refBno;

    @Column(name = "REPLY_WRITER", nullable = false, length = 30)
    private String replyWriter;

    @CreationTimestamp
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "STATUS", nullable = false, length = 1)
    @ColumnDefault("'Y'")
    @Builder.Default
    private String status = "Y";
}