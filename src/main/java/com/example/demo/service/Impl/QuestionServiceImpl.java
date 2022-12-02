package com.example.demo.service.Impl;

import com.example.demo.dto.QuestionDto;
import com.example.demo.dto.QuestionForm;
import com.example.demo.dto.QuestionListItemDto;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    @Override
    public Page<QuestionListItemDto> findAllByCategory(Long categoryId, Pageable pageable) {
        return  questionRepository.findAllByCategory_id(categoryId,pageable)
                .map(question -> new QuestionDto.Builder(question).build());

    }

    @Override
    public QuestionDto findOne(Long id) {
       Question question=questionRepository.getOne(id);
       List<Answer> answers=answerRepository.findAllByQuestion(question);
        return  new QuestionDto.Builder(question).answer(answers).build();

    }

    @Override
    public QuestionListItemDto add(QuestionForm form) {
        // TODO: 27/11/22 need to implement question add Logic
        return null;
    }

    @Override
    public QuestionListItemDto update(Long id, QuestionForm form) {
        // TODO: 27/11/22  need to implement  question update Logic
        return null;
    }

    @Override
    public QuestionListItemDto delete(Long id) {
        return new QuestionDto.Builder(questionRepository.trash(id)).build();
    }

   }


