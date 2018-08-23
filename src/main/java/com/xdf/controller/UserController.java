package com.xdf.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.xdf.pojo.Users;
import com.xdf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    // @Resource(name = "myUserService")// 按照属性名称进行匹配
    @Autowired
    //@Qualifier("myUserService") 哈哈你看不到我
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(Users user){
       Users loginUser= userService.login(user);
       ModelAndView  mv=new ModelAndView("/welcome.jsp");
       mv.addObject("loginUser",loginUser);
       return  mv;
    }

    @RequestMapping("/findAllUsersByPage")
    @ResponseBody
    public  PageInfo findAllUsersByPage(int pageNum){
        System.out.println(pageNum);
        PageInfo pageInfo=new PageInfo();
        //补全属性
        pageInfo.setTotal(userService.getTotalCounts());
        pageInfo.setPageSize(2);
        pageInfo.setPageNum(pageNum);
        //调用后台方法
        List<Users> users=userService.findAllUsersByPage(pageNum,pageInfo.getPageSize());;

        pageInfo.setList(users);
        System.out.println("users====>"+users);
        System.out.println("pageInfo====>"+pageInfo);
        return  pageInfo;
    }

}
