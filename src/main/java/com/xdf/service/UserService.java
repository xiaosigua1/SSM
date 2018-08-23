package com.xdf.service;

import com.xdf.pojo.Users;

import java.util.List;

public interface UserService {

    Users login(Users user);

    long getTotalCounts();

    List<Users> findAllUsersByPage(int i, int pageSize);
}
