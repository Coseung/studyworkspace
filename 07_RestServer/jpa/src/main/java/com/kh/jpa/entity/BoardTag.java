package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOARD_TAG")
@IdClass(BoardTagId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardTag {

    @Id
    @Column(name = "BOARD_NO")
    private Long boardNo;

    @Id
    @Column(name = "TAG_ID")
    private Long tagId;
}