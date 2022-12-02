package com.qcby.hongyanredenvelopes.util;

import com.qcby.hongyanredenvelopes.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenUtil {

    public static Map<String, User> tokenMap = new HashMap<>();

    public static String genToken(User user){
        String token = UUID.randomUUID().toString();
        tokenMap.put(token,user);
        return token;
    }

    public static boolean existToken(String token){
        return tokenMap.containsKey(token);
    }

    public static User getUser(String token){
        return tokenMap.get(token);
    }
}
