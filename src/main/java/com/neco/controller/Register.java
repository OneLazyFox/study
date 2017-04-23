package com.neco.controller;

import com.neco.json.JsonResult;
import com.neco.pojo.User;
import com.neco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
@Controller
public class Register {

    @Autowired
    private UserService userService;

    @RequestMapping("/ajaxCheckName")
    public String checkUsername(User user, ModelMap modelMap) {
        userService.regist(user);
        modelMap.put("username",user.getUsername());
        return "login";
    }
}
