package com.miaojl.sys.controller;

import com.miaojl.sys.constants.SysConstant;
import com.miaojl.sys.utils.ImgCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author mjl
 * @date 2020/3/17
 * @description 验证码控制
 */
@WebServlet("/login/getPic")
public class ImgServlet extends BeanServlet {

    protected void getPic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImgCodeUtil imgCodeUtil = new ImgCodeUtil();
        BufferedImage img = imgCodeUtil.getImage();
        String imgCode = imgCodeUtil.getText();

        //把图片验证码存入session
        HttpSession session = req.getSession();
        session.setAttribute(SysConstant.SESSION_PIC_CODE, imgCode);

        // 禁止图像缓存
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(img, "jpeg", sos);
        sos.flush();
        sos.close();
    }
}
