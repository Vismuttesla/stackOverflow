package com.example.demo.service.Impl;

import com.example.demo.dto.QuestionVoteDto;
import com.example.demo.dto.VoteType;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionVote;
import com.example.demo.entity.User;
import com.example.demo.repository.QuestionVoteRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.QuestionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionVoteServiceImpl implements QuestionVoteService {
    private final QuestionVoteRepository questionVoteRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Override
    public QuestionVoteDto upVote(Long questionId, String username) {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            Optional<QuestionVote> optionalQuestionVote = questionVoteRepository.findByQuestion_idAAndAndCreateBYAndDeletedFalse(questionId, optionalUser.get());
            if (!optionalQuestionVote.isPresent()) {
                QuestionVote vote = new QuestionVote();
                vote.setQuestion(entityManager.getReference(Question.class, questionId));
                vote.setType(VoteType.UP);
                QuestionVoteDto dto = QuestionVoteDto.fromQuestionVote(questionVoteRepository.save(vote));
                // TODO: 27/11/22 Calculate question voteCount
                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
    }

    @Override
    public QuestionVoteDto downVote(Long questionId, String username) {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            Optional<QuestionVote> optionalQuestionVote = questionVoteRepository.findByQuestion_idAAndAndCreateBYAndDeletedFalse(questionId, optionalUser.get());
            if (!optionalQuestionVote.isPresent()) {
                QuestionVote vote = new QuestionVote();
                vote.setQuestion(entityManager.getReference(Question.class, questionId));
                vote.setType(VoteType.DOWN);
                QuestionVoteDto dto = QuestionVoteDto.fromQuestionVote(questionVoteRepository.save(vote));

                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
    }

    @Override
    public QuestionVoteDto revertVote(Long questionId, String username) {

        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            Optional<QuestionVote> optionalQuestionVote = questionVoteRepository.findByQuestion_idAAndAndCreateBYAndDeletedFalse(questionId, optionalUser.get());
            if (!optionalQuestionVote.isPresent()) {
                QuestionVoteDto dto = QuestionVoteDto.fromQuestionVote(questionVoteRepository.trash(optionalQuestionVote.get().getId()));
                reCalculateQuestionVote(dto.getQuestionId());
                return dto;
            }
        }
        return null;
}

    private void reCalculateQuestionVote(Long questionId) {

    }


}
