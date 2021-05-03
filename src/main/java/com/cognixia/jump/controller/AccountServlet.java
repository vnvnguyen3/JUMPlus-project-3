package com.cognixia.jump.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.AccountDAO;
import com.cognixia.jump.dao.AccountDAOClass;
import com.cognixia.jump.model.Account;

public class AccountServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AccountDAO db;
	private PreparedStatement pstmt;
	private Connection conn;
	
	@Override
	public void init() throws ServletException{
		this.db = new AccountDAOClass();
		conn = ConnectionManager.getConnection();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM account WHERE userId = ? AND passcode = ?");	
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		int pass = Integer.parseInt(req.getParameter("passcode"));
		
		try {
			pstmt.setString(1, userId);
			pstmt.setInt(2, pass);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			Account account = new Account(rs.getInt("id"), 
					rs.getString("first"), 
					rs.getString("last"), 
					rs.getString("email"), 
					rs.getString("userId"),
					rs.getInt("passcode"),
					rs.getDouble("amount"));
			
			req.setAttribute("account", account);
			
			if(rs != null) {				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/account.jsp");
				dispatcher.forward(req, resp);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
