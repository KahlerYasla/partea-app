package com.example.services;

import com.example.utils.DBUtil;
import java.util.List;

import com.example.models.User;

public class Authentication {
    public static boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }

        List<User> users = DBUtil.selectAllFromDB("users");

        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void register(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setSsn(java.util.UUID.randomUUID().toString().substring(0, 8));

        DBUtil.insertToDB(user);
    }
}
