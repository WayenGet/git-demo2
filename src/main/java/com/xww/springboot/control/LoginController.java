package com.xww.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    //处理提交后的表单信息
    @PostMapping(value = "/user/login")
    public String reLogin(@RequestParam("username") String username
                            , @RequestParam("password") String password
                            , Map<String,Object> map
                            , HttpSession session){
        //页面重定向
        if("admin".equals(username) && "123456".equals(password)){
            //如果用户名密码正确，则保存到session作用域中
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误，请重新输入！");
        return  "login";
    }
}
