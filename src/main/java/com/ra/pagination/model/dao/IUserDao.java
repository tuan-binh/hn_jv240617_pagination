package com.ra.pagination.model.dao;

import com.ra.pagination.model.entity.Users;

import java.util.List;

public interface IUserDao
{

    List<Users> findAll(int page,int size);

    long totalElement();

}
