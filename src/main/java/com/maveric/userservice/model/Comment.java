package com.maveric.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String commentId;
    private String commentedBy;
    private String comment;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String postId;

}
