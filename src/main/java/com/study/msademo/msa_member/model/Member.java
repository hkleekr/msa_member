package com.study.msademo.msa_member.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * =======================================================
 * @class		: Member
 * @author		: 이혜경
 * @date		: 2024-12-09
 * @desc		: Member domain
 * @history		:
 * -------------------------------------------------------
 * NO	DATE       	AUTHOR	NOTE
 * -------------------------------------------------------
 * 1.	2024-12-09 이혜경
 */
@Entity
@Data
@Table(name = "member")
@NoArgsConstructor
@Builder
public class Member {

    @Id @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "joinDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime joinDate;

    @Column(name = "modifiedDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedDate;

    @Column(name = "grade")
    private String grade;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "addr")
    private String addr;

    @Column(name = "deleteTf")
    private Boolean deleteTf;

    @Column(name = "deletedDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime deletedDate;

    public Member(Long memberId, String memberName, String phone, String email, LocalDateTime joinDate, LocalDateTime modifiedDate, String grade, Integer credit, String addr, Boolean deleteTf, LocalDateTime deletedDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.phone = phone;
        this.email = email;
        this.joinDate = joinDate;
        this.modifiedDate = modifiedDate;
        this.grade = grade;
        this.credit = credit;
        this.addr = addr;
        this.deleteTf = deleteTf;
        this.deletedDate = deletedDate;
    }

    @PrePersist
    void joinDate() {
        this.joinDate = LocalDateTime.now();
    }

    void modifiedDate(){
        this.modifiedDate = LocalDateTime.now();
    }
}
