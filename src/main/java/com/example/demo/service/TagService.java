package com.example.demo.service;

import com.example.demo.dto.TagDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
  List<TagDto> findAll();
  Page<TagDto> findAll(Pageable pageable);
  Page<TagDto> findByTitle(String searchterm,Pageable pageable);
  TagDto add(TagDto form);
  TagDto update(Long id,TagDto form);
  TagDto delete(Long id);

}
