package com.xiangxue.micro.auth.service;


import com.xiangxue.micro.auth.dto.RoleDto;
import com.xiangxue.micro.auth.dto.UserDto;
import com.xiangxue.micro.auth.entities.Role;
import com.xiangxue.micro.auth.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final String LOAD_USER_BY_USERNAME_SQL = "select id,username,password,status from sys_user where username = ?";

    public static final String LOAD_ROLE_BY_USER_ID_SQL = "select " +
            "	role.id, " +
            "	role.name, " +
            "	role.perms, " +
            "	role.sort, " +
            "	role.status, " +
            "	role.deleted, " +
            "	role.remark, " +
            "	role.gmt_create, " +
            "	role.gmt_modified  " +
            "   from " +
            "	sys_role role " +
            "	inner join sys_user_role user_role on role.id = user_role.role_id " +
            "	inner join sys_user usr on user_role.user_id = usr.id  " +
            "	and usr.id = ?";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String clientId = request.getParameter("client_id");
        log.info("授权用户:{},clinetId:{}",username,clientId);
        UserDto user = jdbcTemplate.queryForObject(LOAD_USER_BY_USERNAME_SQL, new BeanPropertyRowMapper<>(UserDto.class), username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        if (user.getStatus() == null || user.getStatus() != 1) {
            throw new UsernameNotFoundException("用户已被注销");
        }
        List<RoleDto> roles = jdbcTemplate.query(LOAD_ROLE_BY_USER_ID_SQL, new BeanPropertyRowMapper<>(RoleDto.class), user.getId());
        if (roles != null && !roles.isEmpty()) {
            List<Long> roleIds = roles.stream().map(s -> s.getId()).collect(Collectors.toList());
            user.setRoles(roleIds);
        }
        return new User(user);
    }
}
