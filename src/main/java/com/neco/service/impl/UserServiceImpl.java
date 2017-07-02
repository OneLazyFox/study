package com.neco.service.impl;

import com.neco.dao.UserDao;
import com.neco.pojo.User;
import com.neco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/23.
 *
 * @author 张小虎
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void regist(User user) {
        UUID uuid = UUID.randomUUID();
        user.setUserAccount(uuid.toString());
        user.setStatus(1);
        userDao.regist(user);
    }
}
