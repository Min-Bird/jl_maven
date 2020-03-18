package com.miaojl.sys.controller;

import com.miaojl.sys.constants.SysConstant;
import com.miaojl.sys.entity.User;
import com.miaojl.sys.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 登录控制
 */
@WebServlet("/login/login")
public class LoginServlet extends BeanServlet {
    private LoginService loginService = new LoginService();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取请求参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String picCode = req.getParameter("picCode");

            HttpSession session = req.getSession();
            Object picObj = session.getAttribute(SysConstant.SESSION_PIC_CODE);
            if (picCode == null) {
                resp.sendRedirect("/index.jsp");
                return;
            }

            if (!picObj.toString().equals(picCode)) {
                System.out.println("验证码不正确！");
                resp.sendRedirect("/index.jsp");
                return;
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //是否返回对象
            User u = loginService.getLoginUser(user);
            if(u==null){
                resp.sendRedirect("/index.jsp");
                return;
            }else{
                resp.sendRedirect("/html/success.jsp");
//                req.getRequestDispatcher("/html/success.jsp").forward(req,resp);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            resp.sendRedirect("/index.jsp");
            return;
        }

    }
}
