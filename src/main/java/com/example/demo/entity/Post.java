package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter

public class Post extends BaseEntity {

    private String title;
    @Column(columnDefinition = "text")
    @Getter
    @Setter

    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private AAAACategory AAAACategory;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<AAAATag> AAAATags;

}
