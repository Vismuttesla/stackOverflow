package com.example.demo.service;

import com.example.demo.dto.QuestionDto;
import com.example.demo.dto.QuestionForm;
import com.example.demo.dto.QuestionListItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Page<QuestionListItemDto> findAllByCategory(Long categoryId, Pageable pageable);
    QuestionDto findOne(Long id);
    QuestionListItemDto add(QuestionForm form);
    QuestionListItemDto update(Long id, QuestionForm form);
    QuestionListItemDto delete (Long id);
}
