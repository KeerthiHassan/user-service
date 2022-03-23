package com.maveric.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String postId;
    private String post;
    private String postedBy;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
