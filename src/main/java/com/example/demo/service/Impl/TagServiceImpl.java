package com.example.demo.service.Impl;

import com.example.demo.dto.TagDto;
import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;
import com.example.demo.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

      private final TagRepository tagRepository;


       @Override
       public List<TagDto> findAll() {
        return tagRepository.findAllNotDeleted().stream().map(TagDto::fromTag).collect(Collectors.toList());
        }

        @Override
        public Page<TagDto> findAll(Pageable pageable) {
        return null;
         }

         @Override
          public Page<TagDto> findByTitle(String searchterm, Pageable pageable) {
          return  tagRepository.findAllNotDeleted(pageable).map(TagDto::fromTag);
            }

    @Override
    public TagDto add(TagDto form) {
        Tag tag=new Tag();
        tag.setTitle(form.getTitle());
        return TagDto.fromTag(tagRepository.save(tag));

    }
    @Override
    public TagDto update(Long id, TagDto form) {
           Tag tag=tagRepository.getOne(id);
           tag.setTitle(form.getTitle());
           return TagDto.fromTag(tagRepository.save(tag));
    }

    @Override
    public TagDto delete(Long id) {
        return TagDto.fromTag(tagRepository.trash(id));
    }
}
