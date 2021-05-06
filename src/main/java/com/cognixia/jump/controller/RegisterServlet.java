package com.cognixia.jump.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.AccountDAO;
import com.cognixia.jump.dao.AccountDAOClass;
import com.cognixia.jump.model.Account;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AccountDAO db;
	
	@Override
	public void init() throws ServletException{
		this.db = new AccountDAOClass();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String email = req.getParameter("email");
		String userId = req.getParameter("userId");
		int pass = Integer.parseInt(req.getParameter("passcode"));
		double amount = Double.parseDouble(req.getParameter("amount"));
		Account account = new Account(0, first_name, last_name, email, userId, pass, amount, "");
		
		db.addAccount(account);
		
		req.setAttribute("account", account);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/account.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
