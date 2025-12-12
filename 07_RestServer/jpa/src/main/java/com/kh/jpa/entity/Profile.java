package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long profileId;

    @Column(name = "USER_ID", unique = true, length = 30)
    private String userId;

    @Column(name = "PROFILE_IMAGE", length = 100)
    private String profileImage;

    @Column(name = "INTRO", length = 300)
    private String intro;
}