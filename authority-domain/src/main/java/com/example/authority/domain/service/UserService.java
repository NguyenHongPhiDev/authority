package com.example.authority.domain.service;

import com.example.authority.domain.model.User;
import com.example.authority.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public List<User> userList(){
        return userRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }
    @Transactional
    public User findById( final Integer id){
        return userRepository
                .findById(id)
                .orElseGet(() -> {
                    log.warn("User not found. User_id {}", id);
                    throw new ResourceNotFoundException("User not found. Username: " + id);
                });
    }
}
