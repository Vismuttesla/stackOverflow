package com.example.demo.dto;

import com.example.demo.entity.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionListItemDto {
    private Long id;
    private Long categoryId;
    private String title;
    private String description;
    private Set<TagDto> tags;
    private Long viewCount;
    private Long time;
    private Long voteCount;
    private UserDto author;



}
