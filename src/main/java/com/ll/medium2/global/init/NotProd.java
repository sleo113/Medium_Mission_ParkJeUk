package com.ll.medium2.global.init;

import com.ll.medium2.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

@Configuration
@Slf4j
@Profile("!prod")
@RequiredArgsConstructor
public class NotProd {

    private final MemberService memberService;

    @Bean
    @Order(3)
    public ApplicationRunner initNotProd() {
        return args -> {
            if (memberService.findByUsername("user1").isPresent()) return;

            memberService.join("system", "1234");
            memberService.join("admin", "1234");
            memberService.join("user1", "1234");
            memberService.join("user2", "1234");
        };
    };
}