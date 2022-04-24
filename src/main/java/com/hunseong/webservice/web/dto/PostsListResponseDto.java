package com.hunseong.webservice.web.dto;

import com.hunseong.webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by Hunseong on 2022/04/24
 */
@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
