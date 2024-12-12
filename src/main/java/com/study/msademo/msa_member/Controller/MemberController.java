package com.study.msademo.msa_member.Controller;

import com.study.msademo.msa_member.model.MemberRequestDto;
import com.study.msademo.msa_member.model.MemberResponseDto;
import com.study.msademo.msa_member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
     * id로 삭제 (논리적 삭제_deleteYn: N -> Y)
     * @param memberId: null 체크!
     * @return
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> deleteMember(@PathVariable(name = "memberId") Long memberId) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto = memberService.deleteMember(Objects.requireNonNull(memberId), memberResponseDto);

        return ResponseEntity.ok().body(memberResponseDto);
    }

    /**
     *
     * @param memberId: null 체크!
     * @param memberRequestDto: phone, email, addr 필수(F/E에서 null 체크 예정)
     * @return
     */
    // TODO: Null체크   annotation 붙여둘 것
    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable(name = "memberId") Long memberId, MemberRequestDto memberRequestDto) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto = memberService.updateMember(Objects.requireNonNull(memberId), memberRequestDto, memberResponseDto);

        return ResponseEntity.ok().body(memberResponseDto);
    }
}
