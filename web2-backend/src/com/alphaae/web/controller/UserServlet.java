package com.alphaae.web.controller;

import com.alphaae.web.dao.UserDao;
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
        response.getOutputStream().write(serializeData().getBytes());
    }

    private String serializeData() {
        return gson.toJson(userDao.getAllUsers());
    }

}
