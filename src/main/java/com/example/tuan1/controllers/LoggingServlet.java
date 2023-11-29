package com.example.tuan1.controllers;

import com.example.tuan1.models.Account;
import com.example.tuan1.repositories.AccountRepository;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/log")
public class LoggingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountRepository accR= new AccountRepository();
        List<Account> accountList= accR.getAllAccounts();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountRepository accR= new AccountRepository();
        Account account= new Account();
        account.setAccount_id(req.getParameter("id"));
        account.setFull_name(req.getParameter("full_name"));
        account.setPassword(req.getParameter("password"));
        account.setEmail(req.getParameter("email"));
        account.setStatus(Integer.parseInt(req.getParameter("status")));
        accR.createAccount(account);
    }
}
