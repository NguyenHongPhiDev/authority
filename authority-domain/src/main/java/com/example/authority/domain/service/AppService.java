package com.example.authority.domain.service;

import com.example.authority.domain.Dto.RoleDto;
import com.example.authority.domain.model.User;
import com.example.authority.domain.repository.RoleRepository;
import com.example.authority.domain.repository.UserRepository;
import com.example.authority.domain.service.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppService {
    private static final Logger logger = LoggerFactory.getLogger(AppService.class);
    private final UserRepository getUser;
    private final RoleRepository getUrlRoles;
    private final RoleMapper roleMapper ;
    @Transactional(readOnly = true)
    public User getUser(String username) {
        return getUser.findUserByUsername(username);
    }

    @Transactional(readOnly = true)
    public List<RoleDto> getUrlRoles() {
        return getUrlRoles.findAll()
                .stream()
                .map(roleMapper::toRoleDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> getUrl(String url) {
        return getUrlRoles.findByRoleActions(url)
                .stream()
                .collect(Collectors.toList());
    }
}
