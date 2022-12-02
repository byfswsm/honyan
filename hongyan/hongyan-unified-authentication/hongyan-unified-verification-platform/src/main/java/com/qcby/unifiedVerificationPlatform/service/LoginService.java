package com.qcby.unifiedVerificationPlatform.service;

import com.qcby.unifiedVerificationPlatform.entity.User;

public interface LoginService  {

    User usernameLogin(User user);

    User phoneEmailLogin(User user);
}
