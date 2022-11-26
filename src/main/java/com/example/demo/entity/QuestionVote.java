package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class QuestionVote extends BaseEntity {

    @ManyToOne
    private  Question question;


}
