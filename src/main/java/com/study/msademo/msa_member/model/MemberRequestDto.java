package com.study.msademo.msa_member.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRequestDto {
    private String memberName;
    private String phone;
    private String email;
    private String grade;   //
    private Integer credit;  //
    private String addr;
    private String deleteYn;  //

    public Member toEntity() {
        return Member.builder()
                .memberName(memberName)
                .phone(phone)
                .email(email)
                .grade(grade)
                .credit(credit)
                .addr(addr)
                .deleteYn(deleteYn)
        .build();
    }
}
