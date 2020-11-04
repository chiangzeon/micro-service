package com.xiangxue.micro.auth.entities;

import lombok.Data;

@Data
public class Role {

    private Long id;

    private String name;

    private String perms;

    private Integer sort;

    private Integer status;

    private Integer deleted;

    private String remark;
}
