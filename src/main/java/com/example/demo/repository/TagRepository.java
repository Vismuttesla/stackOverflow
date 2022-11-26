package com.example.demo.repository;

import com.example.demo.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Set<Tag> findByTitleEndsWithIgnoreCase(String keyword);


}
