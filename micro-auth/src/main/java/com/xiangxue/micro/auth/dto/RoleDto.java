package com.xiangxue.micro.auth.dto;

import com.xiangxue.micro.auth.entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto extends Role {

    private List<Long> menuIds;

    private List<Long> resourceIds;
}
