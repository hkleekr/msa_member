package com.study.msademo.msa_member.repository;

import com.study.msademo.msa_member.model.Member;
import com.study.msademo.msa_member.model.MemberResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(Long memberId);
}
