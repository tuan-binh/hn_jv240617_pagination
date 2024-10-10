package com.ra.pagination.model.service.impl;

import com.ra.pagination.model.dao.IUserDao;
import com.ra.pagination.model.entity.Users;
import com.ra.pagination.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private IUserDao userDao;

    @Override
    public List<Users> findAll(int page, int size)
    {
        return userDao.findAll(page, size);
    }

    @Override
    public double totalPages(int size)
    {
        return Math.ceil((double) userDao.totalElement() / size);
    }
}
