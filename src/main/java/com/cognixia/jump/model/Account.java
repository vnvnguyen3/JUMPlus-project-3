package com.cognixia.jump.model;

import java.util.ArrayList;

public class Account {

	private int id;
	private String first;
	private String last;
	private String email;
	private String userId;
	private int passcode;
	private double amount;
	private ArrayList<String> transactions;
	
	public Account(int id, String first, String last, String email, String userId, int passcode, double amount) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
		this.userId = userId;
		this.passcode = passcode;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPasscode() {
		return passcode;
	}

	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<String> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", first=" + first + ", last=" + last + ", email=" + email + ", userId=" + userId
				+ ", passcode=" + passcode + ", amount=" + amount + ", transactions=" + transactions + "]";
	}
	
}
