package com.study.msademo.msa_member.Controller;

import com.study.msademo.msa_member.model.MemberRequestDto;
import com.study.msademo.msa_member.model.MemberResponseDto;
import com.study.msademo.msa_member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 전체 Member 조회
     * @return
     */
    @GetMapping("")
    public List<MemberResponseDto> getMembers() {
        return memberService.getMembers();
    }

    /**
     * Member 신규 등록
     * @param memberRequestDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<MemberResponseDto> createMember(MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto = memberService.createMember(memberRequestDto, memberResponseDto);

        return ResponseEntity.ok().body(memberResponseDto);
    }

    /**
     * id로 삭제(논리적 삭제)
     * @param memberId
     * @return
     */
    @DeleteMapping("")
    public ResponseEntity<MemberResponseDto> deleteMember(Long memberId) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto = memberService.deleteMember(memberId);
    }
}
