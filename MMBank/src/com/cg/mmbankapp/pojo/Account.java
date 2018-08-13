package com.cg.mmbankapp.pojo;

public abstract class Account {
	private final int accountNumber;
	private Customer accountHolder;
	private double accountBalance;
	private String accountType;
	private String withdrawcheck;
	
	//maintains the next accountNumber
	private static int accountId;
	
	//gets invoked whenever a class is loaded
	static {
		accountId = 100;
	}

	//gets invoked whenever a new object is created
	{
		this.accountNumber = ++accountId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", accountBalance="
				+ accountBalance + ", accountType=" + accountType + ", withdrawcheck=" + withdrawcheck + "]";
	}

	public Customer getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getWithdrawcheck() {
		return withdrawcheck;
	}

	public void setWithdrawcheck(String withdrawcheck) {
		this.withdrawcheck = withdrawcheck;
	}

	public static int getAccountId() {
		return accountId;
	}

	public static void setAccountId(int accountId) {
		Account.accountId = accountId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public abstract String withdraw(double amountToBeWithDrawn);
	
	//For Non-Zero Balance Account.
	public Account(Customer accountHolder, double accountBalance, String accountType) {
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
		this.accountType=accountType;
	}
	
	//For Zero Balance account holders
	public Account(Customer accountHolder,String accountType) {
		this.accountHolder = accountHolder;
		this.accountType=accountType;
	}
	public void deposit(double amountToBeDeposited) {
		if(amountToBeDeposited>0) {
			this.accountBalance+=amountToBeDeposited;
		}
	}
}
