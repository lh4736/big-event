package com.example.bigevent.service;

import com.example.bigevent.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author lh
 * @Date 2024/3/11 22:34
 */
public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}
