package com.xdf.dao;

import com.xdf.pojo.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public Users login(Users user);

    int getTotalCounts();

    List<Users> findAllUsersByPage(int i, int pageSize);
}
