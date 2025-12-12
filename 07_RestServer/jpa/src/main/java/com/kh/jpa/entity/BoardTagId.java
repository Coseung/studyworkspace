package com.kh.jpa.entity;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardTagId implements Serializable {
    private Long boardNo;
    private Long tagId;
}