package com.example.demo.repository;

import com.example.demo.entity.QuestionVote;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionVoteRepository extends BaseRepository<QuestionVote>{
    Optional<QuestionVote> findByQuestion_idAAndAndCreateBYAndDeletedFalse
            (Long questionId, User user);
}
