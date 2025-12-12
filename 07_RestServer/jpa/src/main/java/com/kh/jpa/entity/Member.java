package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @Column(name = "USER_ID", length = 30)
    private String userId;

    @Column(name = "USER_PWD", nullable = false, length = 100)
    private String userPwd;

    @Column(name = "USER_NAME", nullable = false, length = 15)
    private String userName;

    @Column(name = "EMAIL", length = 254)
    private String email;

    @Column(name = "GENDER", length = 1)
    private String gender;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE", length = 13)
    private String phone;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @CreationTimestamp
    @Column(name = "ENROLL_DATE", updatable = false)
    private LocalDateTime enrollDate;

    @UpdateTimestamp
    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Column(name = "STATUS", nullable = false, length = 1)
    @ColumnDefault("'Y'")
    @Builder.Default
    private String status = "Y";
}