package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name="BOARD")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="board_id")
    private Long boardId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(name="file_name")
    private String fileName;


    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @JoinColumn(name ="member_email", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;


    public void patchUpdate(String title, String contents, String fileName) {
        if(title != null) {
            this.title = title;
        }

        if(contents != null) {
            this.contents = contents;
        }

        if(fileName != null) {
            this.fileName = fileName;
        }
    }
}
