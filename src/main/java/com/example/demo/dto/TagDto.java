package com.example.demo.dto;

import com.example.demo.entity.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDto {

    private Long id;
    private String title;

    public static TagDto fromTag(Tag tag) {
  TagDto dto=new TagDto();
  dto.setId(tag.getId());
  dto.setTitle(tag.getTitle());
        return dto;
    }

}
