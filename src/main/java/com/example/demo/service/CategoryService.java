package com.example.demo.service;

import com.example.demo.dto.CategoryDto;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll(@Nullable Long parentId);// nullable bu yerda parent
    // id ni null bo'lishini ham ko'rsatish uchun
    CategoryDto findOne(Long id);
    CategoryDto add(CategoryDto form);
    CategoryDto update(Long id,CategoryDto form);
    CategoryDto delete(Long id);


}
