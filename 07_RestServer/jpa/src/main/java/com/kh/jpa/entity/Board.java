package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO")
    private Long boardNo;

    @Column(name = "BOARD_TITLE", nullable = false, length = 100)
    private String boardTitle;

    @Column(name = "BOARD_WRITER", nullable = false, length = 30)
    private String boardWriter;

    @Lob
    @Column(name = "BOARD_CONTENT", nullable = false)
    private String boardContent;

    @Column(name = "ORIGIN_NAME", length = 100)
    private String originName;

    @Column(name = "CHANGE_NAME", length = 100)
    private String changeName;

    @Column(name = "COUNT")
    @ColumnDefault("0")
    @Builder.Default
    private Integer count = 0;

    @CreationTimestamp
    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "STATUS", nullable = false, length = 1)
    @ColumnDefault("'Y'")
    @Builder.Default
    private String status = "Y";
}