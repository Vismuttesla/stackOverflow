package com.example.demo.controller;

import com.example.demo.service.QuestionVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/question-vote")
@RequiredArgsConstructor
public class QuestionVoteController {

    private final QuestionVoteService questionVoteService;


    @PutMapping("{questionId}/up")
    public ResponseEntity upVote(@PathVariable Long questionId, Principal principal) {
        return ResponseEntity.ok(questionVoteService.upVote(questionId, principal.getName()));
    }

    @PutMapping("{questionId}/down")
    public ResponseEntity downVote(@PathVariable Long questionId, Principal principal) {
        return ResponseEntity.ok(questionVoteService.downVote(questionId, principal.getName()));
    }

    @PutMapping("{questionId}/revert")
    public ResponseEntity revertVote(@PathVariable Long questionId, Principal principal) {
        return ResponseEntity.ok(questionVoteService.revertVote(questionId, principal.getName()));
    }


}
