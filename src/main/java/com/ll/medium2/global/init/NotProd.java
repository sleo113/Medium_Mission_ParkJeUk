package com.ll.medium2.global.init;

import com.ll.medium2.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class NotProd {

    private final MemberService memberService;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            memberService.join("system", "system");
            memberService.join("admin", "admin");
            memberService.join("user1", "1234");
            memberService.join("user2", "1234");
        };
    };
}