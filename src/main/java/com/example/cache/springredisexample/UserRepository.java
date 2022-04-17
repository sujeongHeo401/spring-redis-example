package com.example.cache.springredisexample;

import com.example.cache.springredisexample.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    void save(User user);
    Map<String, User> findAll();
//    List<User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}
