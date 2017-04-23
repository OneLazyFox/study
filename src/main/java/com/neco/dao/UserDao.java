package com.neco.dao;

import com.neco.pojo.User;
import guava.annotation.DbTest;

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
@DbTest
public interface UserDao {
    public void regist(User user);
}
