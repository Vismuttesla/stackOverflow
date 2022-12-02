package com.example.demo.dto;

import com.example.demo.entity.QuestionVote;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionVoteDto {
    private Long id;
    private Long questionId;
    private VoteType type;

    public static QuestionVoteDto fromQuestionVote(QuestionVote vote) {
        QuestionVoteDto dto = new QuestionVoteDto();
        dto.setId(vote.getId());
        dto.setQuestionId(vote.getQuestion().getId());
        dto.setType(vote.getType());
        return dto;
    }

}
