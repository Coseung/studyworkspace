package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "NOTICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    @Column(name = "NOTICE_TITLE", nullable = false, length = 30)
    private String noticeTitle;

    @Column(name = "NOTICE_WRITER", nullable = false, length = 30)
    private String noticeWriter;

    @Column(name = "NOTICE_CONTENT", nullable = false, length = 200)
    private String noticeContent;

    @CreationTimestamp
    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;
}