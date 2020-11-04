package com.xiangxue.micro.auth.service;

import lombok.SneakyThrows;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * 客户端认证
 */
public class ClientDetailsService extends JdbcClientDetailsService {

    public ClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    @SneakyThrows
    public ClientDetails loadClientByClientId(String clientId)  {
        return super.loadClientByClientId(clientId);
    }
}
