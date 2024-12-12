package com.study.msademo.msa_member.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequestDto {
    private String memberName;
    private String phone;
    private String email;
    private String grade;   // default
    private Integer credit;  // default
    private String addr;
    private Boolean deleteTf;  // default

    public Member toEntity() {
        return Member.builder()
                .memberName(memberName)
                .phone(phone)
                .email(email)
                .grade(grade)
                .credit(credit)
                .addr(addr)
                .deleteTf(deleteTf)
        .build();
    }
}
