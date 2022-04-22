package com.hunseong.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Hunseong on 2022/04/22
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
