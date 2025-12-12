package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TAG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name = "TAG_NAME", nullable = false, unique = true, length = 30)
    private String tagName;
}