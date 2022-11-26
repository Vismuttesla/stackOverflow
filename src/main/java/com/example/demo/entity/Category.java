package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {

    private String title;
    @Column(columnDefinition = "text")
     private String description;

    @ManyToOne(fetch= FetchType.LAZY)
    private Category parent;

    private String iconCode;


}


