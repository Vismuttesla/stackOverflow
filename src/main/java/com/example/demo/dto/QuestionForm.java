package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionForm {

  private Long categoryId;
  private String title;
  private String description;
  private Set<TagDto> tags;

}
