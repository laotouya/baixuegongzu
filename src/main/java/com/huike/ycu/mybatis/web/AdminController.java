package com.huike.ycu.mybatis.web;

import com.huike.ycu.mybatis.model.UmsAdmin;
import com.huike.ycu.mybatis.result.Result;
import com.huike.ycu.mybatis.service.AdminService;
import com.huike.ycu.mybatis.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello, 欢迎！！！";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result<UmsAdmin> login(Model model, String username, String password) {
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername(username);
        admin.setPassword(password);

        Result<UmsAdmin> login = this.adminService.login(admin);

        return login;
    }



    @PostMapping("/signup")
    @ResponseBody
    public String zhuce( String username, String password) {
        ModelAndView mav = new ModelAndView();


        UmsAdmin admin = new UmsAdmin();
        password = MD5Util.inputPassToDbPass(password, MD5Util.salt);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setSalt(MD5Util.salt);

        int a  = this.adminService.zhuce(admin);
        if(a == 0) {
            mav.setStatus(HttpStatus.OK);
            mav.addObject("msg", "注册失败");

            return mav.toString();
        }else {

            mav.addObject("msg", "注册成功");
        }
        return mav.toString();
    }
}
