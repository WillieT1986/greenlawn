package com.wrthompsonjr.greenlawn;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;

@Resource
public interface TagRepository extends JpaRepository<Tag, Long> {
}