package com.xiangxue.micro.auth.entities;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Oauth2Token {

    /**
     * 访问令牌
     */
    private String token;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 有效时间(秒)
     */
    private int expiresIn;

}
