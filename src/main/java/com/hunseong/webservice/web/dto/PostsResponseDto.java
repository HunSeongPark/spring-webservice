package com.hunseong.webservice.web.dto;

import com.hunseong.webservice.domain.posts.Posts;
import lombok.Getter;

/**
 * Created by Hunseong on 2022/04/22
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
