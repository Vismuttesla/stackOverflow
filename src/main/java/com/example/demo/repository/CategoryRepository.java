package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends BaseRepository<Category>
{
    List<Category> findAllByParent_IdAndDeletedFalse(Long parentId);


}
