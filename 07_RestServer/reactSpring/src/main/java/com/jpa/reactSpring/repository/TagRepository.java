package com.jpa.reactSpring.repository;

import com.jpa.reactSpring.dto.MemoDto;
import com.jpa.reactSpring.entity.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> findTagByMemberId(Long memberId);
}
