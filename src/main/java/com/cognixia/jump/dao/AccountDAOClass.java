package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Account;
public class AccountDAOClass implements AccountDAO{
	
	private static final Connection conn = ConnectionManager.getConnection();
	
	private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM account";
	private static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM account WHERE id = ?";
	private static final String ADD_ACCOUNT = "INSERT INTO account(first, last, email, id, passcode, amount) values (?, ?, ?, ?, ?, ?)";

	@Override
	public boolean addAccount(Account a) {
		try (PreparedStatement pstmt = conn.prepareStatement(ADD_ACCOUNT);){
			pstmt.setString(1, a.getFirst());
			pstmt.setString(2, a.getLast());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getUserId());
			pstmt.setInt(5, a.getPasscode());
			pstmt.setDouble(6, a.getAmount());
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_ACCOUNTS);
				ResultSet rs = pstmt.executeQuery();) {
			while(rs.next()) {
				accounts.add(new Account(rs.getInt("id"), 
						rs.getString("first"), 
						rs.getString("last"), 
						rs.getString("email"), 
						rs.getString("userId"),
						rs.getInt("passcode"),
						rs.getDouble("amount")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ACCOUNT_BY_ID);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			account = new Account(rs.getInt("id"), 
					rs.getString("first"), 
					rs.getString("last"), 
					rs.getString("email"), 
					rs.getString("userId"),
					rs.getInt("passcode"),
					rs.getDouble("amount"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return account;
	}
	
	
}
