package com.ll.medium2.global.init;

import com.ll.medium2.domain.member.member.entity.Member;
import com.ll.medium2.domain.member.member.service.MemberService;
import com.ll.medium2.domain.post.post.service.PostService;
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
    private final PostService postService;

    @Bean
    @Order(3)
    public ApplicationRunner initNotProd() {
        return args -> {
            if (memberService.findByUsername("user1").isPresent()) return;

            Member memberUser1 = memberService.join("user1", "1234").getData();
            Member memberUser2 = memberService.join("user2", "1234").getData();
            Member memberUser3 = memberService.join("user3", "1234").getData();

            postService.write(memberUser1, "제목 1", "내용 1", true);
            postService.write(memberUser1, "제목 2", "내용 2", true);
            postService.write(memberUser1, "제목 3", "내용 3", false);
            postService.write(memberUser1, "제목 4", "내용 4", true);

            postService.write(memberUser2, "제목 5", "내용 5", true);
            postService.write(memberUser2, "제목 6", "내용 6", false);
        };
    };
}