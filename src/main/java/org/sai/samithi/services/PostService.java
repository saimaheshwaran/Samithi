package org.sai.samithi.services;

import org.sai.samithi.entities.Post;
import org.sai.samithi.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post add(Post post) {
        post.setPublishedOn(Date.from(Instant.now()));
        return postRepository.save(post);
    }

    public Page<Post> postPageRequest(int page, int pageSize) {
        return postRepository.findAll(
                PageRequest.of( page, pageSize,
                        Sort.by(Sort.Direction.DESC, "publishedOn")));
    }
}
