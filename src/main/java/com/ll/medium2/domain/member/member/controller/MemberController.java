package com.ll.medium2.domain.member.member.controller;

import com.ll.medium2.domain.member.member.entity.Member;
import com.ll.medium2.domain.member.member.service.MemberService;
import com.ll.medium2.global.rq.Rq.Rq;
import com.ll.medium2.global.rsData.RsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    public MemberController(MemberService memberService, Rq rq) {
        this.memberService = memberService;
        this.rq = rq;
    }

    @GetMapping("/")
    public String showJoin() {
        return "domain/member/member/join";
    }

    @Setter
    @Getter
    public static class JoinForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm) {
        RsData<Member> joinRs = memberService.join(joinForm.getUsername(), joinForm.getPassword());


        return rq.redirectOrBack(joinRs, "/member/login");
    }
}
