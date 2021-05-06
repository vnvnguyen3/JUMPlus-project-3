package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.AccountDAO;
import com.cognixia.jump.dao.AccountDAOClass;
import com.cognixia.jump.model.Account;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AccountDAO db;
	private PreparedStatement pstmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException{
		this.db = new AccountDAOClass();
		conn = ConnectionManager.getConnection();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM bankAccount WHERE userId = ?");	
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double amount = Double.parseDouble(req.getParameter("amount"));
		String transaction = "Deposited $"+amount+" into account\n";
		String userId = req.getParameter("userId");
		try {			
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			Account account = new Account(rs.getInt("id"), 
					rs.getString("firstName"), 
					rs.getString("lastName"), 
					rs.getString("email"), 
					rs.getString("userId"),
					rs.getInt("passcode"),
					rs.getDouble("amount") + amount,
					rs.getString("transactions").concat(transaction));
			db.updateAccount(account);
			
			req.setAttribute("account", account);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/success.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
