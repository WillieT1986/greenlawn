package com.wrthompsonjr.greenlawn.data;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wrthompsonjr.greenlawn.models.Tag;

@Resource
public interface TagRepository extends JpaRepository<Tag, Long> {
}