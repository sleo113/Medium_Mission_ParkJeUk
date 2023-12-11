package com.ll.medium2.domain.member.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/")
    public String showJoin() {
        return "domain/member/member/join";
    }
}
