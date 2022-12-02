package com.example.demo.entity;

import com.example.demo.dto.VoteType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class QuestionVote extends BaseEntity {

    @ManyToOne
    private  Question question;

    @Enumerated(EnumType.STRING)
    private VoteType type;

}
