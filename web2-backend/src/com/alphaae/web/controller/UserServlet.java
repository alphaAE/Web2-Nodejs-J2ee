package com.alphaae.web.controller;

import com.alphaae.web.dao.UserDao;
import com.alphaae.web.entity.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/api/users")
public class UserServlet extends HttpServlet {

    private Gson gson = new Gson();

    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");
        String data = request.getParameter("data");
        User userData = null;

        //检查参数完整性与正确性
        if (command == null && data == null) {
            response.sendError(500, "请求参数不完整");
            return;
        }
        try {
            userData = gson.fromJson(data, User.class);
        } catch (Exception e) {
            response.sendError(500, "请求参数数据错误或不完整");
            return;
        }

        System.out.println(data);
        switch (command) {
            case "getAll":
                repJson(response, userDao.getAllUsers());
                return;
            case "findByUserName":
                repJson(response, userDao.findByUserName(userData.getUsername()));
                return;
            case "add":
                //由于数据库字段非空，填充默认密码
                userData.setPassword("123456");
                repJson(response, userDao.addUser(userData));
                return;
            case "delete":
                repJson(response, userDao.delUser(userData));
                return;
            case "update":
                repJson(response, userDao.updateUser(userData));
                return;
            default:
                response.sendError(500, "未知的参数");
        }
    }

    private void repJson(HttpServletResponse response, Object obj) throws IOException {
        response.getOutputStream().write(gson.toJson(obj).getBytes());
    }


}
