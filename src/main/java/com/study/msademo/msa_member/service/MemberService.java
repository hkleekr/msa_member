package com.study.msademo.msa_member.service;

import com.study.msademo.msa_member.model.Member;
import com.study.msademo.msa_member.model.MemberRequestDto;
import com.study.msademo.msa_member.model.MemberResponseDto;
import com.study.msademo.msa_member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    String DEFAULTGRADE = "PRIME";
    Integer DEFAULTCREDIT = 10;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto memberRequestDto, MemberResponseDto memberResponseDto) {

        memberRequestDto.setGrade(DEFAULTGRADE);
        memberRequestDto.setCredit(DEFAULTCREDIT);
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
}
