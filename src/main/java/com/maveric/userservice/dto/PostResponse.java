package com.maveric.userservice.dto;

import com.maveric.userservice.model.Comment;
import com.maveric.userservice.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Post post;
    private List<Comment> commentList;
}
