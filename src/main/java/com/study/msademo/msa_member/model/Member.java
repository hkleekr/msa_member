package com.study.msademo.msa_member.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

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

    @Column(name = "grade")
    private String grade;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "addr")
    private String addr;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "member")
//    private List<MemberOrderHistory> memberOrderHistories;

    /* 기본 생성자: JPA에서 리플렉션을 통해 객체 생성에 사용되는 기본 생성자_외부에서의 객체 생성을 방지함 */
    @PrePersist
    void joinDate() {
        this.joinDate = LocalDateTime.now();
    }

}
