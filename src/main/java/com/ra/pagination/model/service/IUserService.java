package com.ra.pagination.model.service;

import com.ra.pagination.model.entity.Users;

import java.util.List;

public interface IUserService
{

    List<Users> findAll(int page,int size);

    double totalPages(int size);

}
