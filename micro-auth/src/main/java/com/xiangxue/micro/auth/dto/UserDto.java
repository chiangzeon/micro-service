package com.xiangxue.micro.auth.dto;

import com.xiangxue.micro.auth.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto extends User {

    private List<Long> roles;

}
