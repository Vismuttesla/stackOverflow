package com.example.demo.service.Impl;


import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll(Long parentId) {

        return categoryRepository.findAllByParent_IdAndDeletedFalse(parentId).stream().map(CategoryDto::fromCategory).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findOne(Long id) {

        return CategoryDto.fromCategory(categoryRepository.getOne(id));
    }

    @Override
    public CategoryDto add(CategoryDto form) {
        return CategoryDto.fromCategory(categoryRepository.save(fillCAtegory(new Category(), form)));

    }

    @Override
    public CategoryDto update(Long id, CategoryDto form) {
        return CategoryDto.fromCategory(categoryRepository.
                save(fillCAtegory(categoryRepository.getOne(id), form)));

    }

    @Override
    public CategoryDto delete(Long id) {

        return CategoryDto.fromCategory(categoryRepository.trash(id));
    }

    private Category fillCAtegory(Category category, CategoryDto form) {
        category.setTitle(form.getTitle());
        category.setDescription(form.getDescription());
        category.setIconCode(form.getIcon());
        if (form.getParentId() != null) {

            category.setParent(categoryRepository.getOne(form.getParentId()));

        }
        return category;
    }
}
