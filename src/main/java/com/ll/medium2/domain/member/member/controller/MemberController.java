package com.ll.medium2.domain.member.member.controller;

import com.ll.medium2.domain.member.member.entity.Member;
import com.ll.medium2.domain.member.member.service.MemberService;
import com.ll.medium2.global.rq.Rq.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.util.URLEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;

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
        Member member = memberService.join(joinForm.getUsername(), joinForm.getPassword());

        String msg = "%s님 환영합니다. 회원가입이 완료되었습니다. 로그인 후 이용해주세요.".formatted(member.getUsername());
        msg = new URLEncoder().encode(msg, StandardCharsets.UTF_8);
        return "redirect:/?msg=" + msg;
    }
}
