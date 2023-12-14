package com.ll.medium2.domain.member.member.service;

import com.ll.medium2.domain.member.member.entity.Member;
import com.ll.medium2.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member join(String username, String password) {
        Member member = new Member(username, password);
        memberRepository.save(member);

        if (findByUsername(username).isPresent()) {
            return null;
        }

        return member;
    }

    private Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

}