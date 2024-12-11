package com.study.msademo.msa_member.service;

import com.study.msademo.msa_member.model.Member;
import com.study.msademo.msa_member.model.MemberRequestDto;
import com.study.msademo.msa_member.model.MemberResponseDto;
import com.study.msademo.msa_member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    String DEFAULTGRADE = "PRIME";
    Integer DEFAULTCREDIT = 10;
    String DEFAULTDELETEYN = "N";

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto memberRequestDto, MemberResponseDto memberResponseDto) {

        memberRequestDto.setGrade(DEFAULTGRADE);
        memberRequestDto.setCredit(DEFAULTCREDIT);
        memberRequestDto.setDeleteYn(DEFAULTDELETEYN);
        Member savedMember = memberRepository.save(memberRequestDto.toEntity());

        return memberResponseDto.fromEntity(savedMember);
    }

    @Transactional
    public List<MemberResponseDto> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::fromEntity)
                .toList();
    }

    @Transactional
    public MemberResponseDto deleteMember(Long memberId,MemberResponseDto memberResponseDto) {
        Member targetedMember = memberRepository.findByMemberId(memberId);   //1. 논리적 삭제 대상 레코드 id로 조회
        targetedMember.setDeleteYn("Y");        //2. 논리적 삭제 필드'Y'로 변경(update)
        targetedMember.setDeletedDate(LocalDateTime.now());

        Member logicalDeletedMember = memberRepository.save(targetedMember);    //2. 업데이트 할 레코드 repo 로 전송
        return memberResponseDto.fromEntity(logicalDeletedMember);
    }

    @Transactional
    public MemberResponseDto updateMember(Long memberId, MemberRequestDto memberRequestDto, MemberResponseDto memberResponseDto) {
        //1. 업데이트 대상 레코드 id로 조회
        Member targetedMember = memberRepository.findByMemberId(memberId);

        targetedMember.setPhone(memberRequestDto.getPhone());
        targetedMember.setEmail(memberRequestDto.getEmail());
        targetedMember.setAddr(memberRequestDto.getAddr());
        targetedMember.setModifiedDate(LocalDateTime.now());

        Member updatedMember = memberRepository.save(targetedMember);    //2. 업데이트 할 레코드 repo 로 전송

        return memberResponseDto.fromEntity(updatedMember);
    }
}
