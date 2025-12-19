package com.jpa.reactSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//추가 엔티티 , 기능 추가 예정
public class Git {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pushId;
    private String pushDate;
    private String repoName;
    private String branch;
    private String memo;
}
