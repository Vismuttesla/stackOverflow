package com.example.demo.dto;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionVote;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDto extends QuestionListItemDto {
    private QuestionVoteDto vote;
    // TODO: 26/11/22  There must be answer items


    public static class Builder {
        private Question question;

        private List<Answer> answers;
         private QuestionVote vote;
        public Builder(Question question) {
            this.question = question;

        }

        public Builder vote(QuestionVote vote) {
            this.vote = vote;
            return this;
        }

        public Builder answer(List<Answer> answers) {
            this.answers = answers;
            return this;
        }

        public QuestionDto build() {
            QuestionDto dto = new QuestionDto();
            dto.setId(question.getId());
            dto.setTitle(question.getTitle());
            dto.setTags(question.getTags().stream().map(TagDto::fromTag).collect(Collectors.toSet()));
            dto.setDescription(question.getDescription());
            dto.setVoteCount(question.getVoteCount());
            dto.setTime(question.getCreatedDate().getTime());
            if (question.getCreateBY() != null) {
                dto.setAuthor(UserDto.fromUser(question.getCreateBY()));
            }
            // TODO: 27/11/22 set vote
            if (this.answers != null) {   // TODO: 27/11/22 set answers
            }
            return dto;

        }


    }


}





