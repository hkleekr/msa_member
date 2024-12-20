package com.study.msademo.msa_member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class MemberResponseDto {

    private Long memberId;
    private String memberName;
    private String phone;
    private String email;
    private LocalDateTime joinDate;
    private LocalDateTime modifiedDate;
    private String grade;
    private Integer credit;
    private String addr;
    private Boolean deleteTf;
    private LocalDateTime deletedDate;

    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .phone(member.getPhone())
                .email(member.getEmail())
                .joinDate(member.getJoinDate())
                .modifiedDate(member.getModifiedDate())
                .grade(member.getGrade())
                .credit(member.getCredit())
                .addr(member.getAddr())
                .deleteTf(member.getDeleteTf())
                .deletedDate(member.getDeletedDate())
                .build();
    }

    public MemberResponseDto() {
    }
}
