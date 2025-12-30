package com.jpa.reactSpring.domain.repository;

import com.jpa.reactSpring.domain.entity.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> findTagByMemberId(Long memberId);
}
