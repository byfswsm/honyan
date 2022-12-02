package com.qcby.hongyanchat.service;

import com.qcby.hongyanchat.model.User;

import java.util.List;

public interface IUserService {

    boolean login(String username, String passwd);

    boolean register(String username, String passwd);

    void batchAdd(String username,String passwd);

    List<User> getUserList(String username);
}
