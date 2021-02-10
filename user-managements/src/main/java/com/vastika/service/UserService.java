package com.vastika.service;


import com.vastika.model.User;

import java.util.List;

public interface UserService {

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUser();
}
