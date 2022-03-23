package com.maveric.userservice.feign;

import com.maveric.userservice.dto.PostResponse;
import com.maveric.userservice.model.Post;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="post",fallbackFactory = HystrixFallBackFactory.class)
public interface Feign {
@LoadBalanced
 /*   @GetMapping("/api/v1/posts/post")
    public ResponseEntity<List<Post>> getPosts();*/

    @GetMapping("/api/v1/post/posts/{id}")
    public List<Post> findBypostedBy(@PathVariable ("id") String postById);

    @GetMapping("/api/v1/post/getposts/{id}")
    public ResponseEntity<PostResponse> getPostDetails(@PathVariable ("id") String postId);
}
