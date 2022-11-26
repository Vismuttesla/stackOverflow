package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity findAllByParent(@RequestParam(required = false) Long parentId) {
        return ResponseEntity.ok(service.findAll(parentId));

    }

    @GetMapping("{id}")
    public ResponseEntity findOne (@PathVariable(required = false) Long Id) {
        return ResponseEntity.ok(service.findOne(Id));
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR','MODERATOR')")
    public ResponseEntity  add(@RequestBody CategoryDto form){
        return ResponseEntity.ok(service.add(form));

    }
    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR','MODERATOR')")

    public ResponseEntity update(@PathVariable Long id, @RequestBody CategoryDto form){
        return ResponseEntity.ok(service.update(id,form));

    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.delete(id));


    }


}
