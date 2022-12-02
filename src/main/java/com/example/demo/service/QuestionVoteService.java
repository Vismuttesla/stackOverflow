package com.example.demo.service;

import com.example.demo.dto.QuestionVoteDto;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionVote;

public interface QuestionVoteService {
    QuestionVoteDto upVote(Long questionId,String username);

    QuestionVoteDto downVote(Long questionId,String username);

    QuestionVoteDto revertVote(Long questionId,String username);


}
