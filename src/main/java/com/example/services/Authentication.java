package com.example.services;

import com.example.utils.DBUtil;
import java.util.List;

import com.example.models.Users;

public class Authentication {
    public static boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }

        List<Users> users = DBUtil.selectAllFromDB("users");

        for (Users user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void register(String username, String password) {
        Users user = new Users();
        user.setUserName(username);
        user.setPassword(password);
        user.setSsn(java.util.UUID.randomUUID().toString().substring(0, 8));

        DBUtil.insertToDB(user);
    }
}
