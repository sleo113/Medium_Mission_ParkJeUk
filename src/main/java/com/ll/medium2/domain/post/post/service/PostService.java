package com.ll.medium2.domain.post.post.service;

import com.ll.medium2.domain.member.member.entity.Member;
import com.ll.medium2.domain.post.post.entity.Post;
import com.ll.medium2.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void write(Member author, String title, String body, boolean isPublished) {
        Post post = Post.builder()
                .author(author)
                .title(title)
                .body(body)
                .isPublished(isPublished)
                .build();

        postRepository.save(post);
    }
}