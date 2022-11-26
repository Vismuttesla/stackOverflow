package com.example.demo.entity;

import com.example.demo.dto.UserRole;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Table(name = "my_user" )
@Entity
@Getter
@Setter
public class User extends BaseEntity {


    @Column(unique = true)
    private String email;
     private String password;

     @Column(nullable = false)
     @ColumnDefault("false")
    private boolean confirmed=false;
     private String fullName;

     @Enumerated(EnumType.STRING)
    private UserRole role=UserRole.USER;



}
