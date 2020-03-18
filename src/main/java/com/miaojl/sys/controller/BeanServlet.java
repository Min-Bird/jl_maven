package com.miaojl.sys.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author mjl
 * @date 2020/3/18
 * @description 公共servlet
 */
public class BeanServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //反射
        Class clazz = this.getClass();
        String clazzName = clazz.getName();
        String uri = req.getRequestURI();
        String[] uris = uri.split("/");
        String endUri = uris[uris.length-1];
        try {
            Method method = clazz.getDeclaredMethod(endUri,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
