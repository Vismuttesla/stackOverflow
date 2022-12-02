package com.example.demo.repository;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends BaseRepository<Answer>{
   List<Answer> findAllByQuestion(Question question);

}
