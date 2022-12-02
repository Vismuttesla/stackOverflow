package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {


        private Long id;
        private String fullname;

    public static UserDto fromUser(User user)
        {
        UserDto dto = new UserDto();
        dto.setFullname(user.getFullName());
        dto.setId(user.getId());
        return dto;

        }

}
