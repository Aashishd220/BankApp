package com.cg.mmbankapp.services;

import com.cg.mmbankapp.dao.BankAppDao;
import com.cg.mmbankapp.dao.BankAppDaoInterface;
import com.cg.mmbankapp.pojo.Account;
import com.cg.mmbankapp.pojo.CurrentAccount;
import com.cg.mmbankapp.pojo.SavingAccount;

import java.util.Collection;

public class BankAppService {
	BankAppDaoInterface accountDAO = new BankAppDao();
	Account customer = null;
	private Account accountsender;
	private Account accountreceiver;

	public void AddNewAccount(Account account) {
		accountDAO.AddNewAccount(account);
	}

	public void AddNewCurrentAccount(CurrentAccount account) {
		accountDAO.AddNewCurrentAccount(account);
	}

	public void AddNewSavingAccount(SavingAccount account) {
		accountDAO.AddNewSavingAccount(account);
	}

	public Account searchAccount(int AccountNo) {
		for (Account bankAccount : viewAccount()) {
			if (bankAccount.getAccountNumber() == AccountNo) {
				customer = bankAccount;
				break;
			}
		}
		return customer;
	}

	public Collection<Account> viewAccount() {
		return accountDAO.viewAccount().values();
	}

	public Collection<Account> viewCustomer() {
		return accountDAO.viewCustomer().values();
	}

	public boolean Fundtransfer(int sender, int reciever, double amount, String remarks) {
		boolean stat = false;
		accountsender = searchAccount(sender);
		accountreceiver = searchAccount(reciever);
		if (accountsender != null && accountreceiver != null && accountsender.withdraw(amount).equals("yes")) {
			stat = true;
			accountreceiver.deposit(amount);
		} else {
			stat = false;
		}
		return stat;
	}

	public Account withdrawl(double amount, int accNo) {
		customer = searchAccount(accNo);
		System.out.println();
		if (customer != null && customer.withdraw(amount).equals("yes")) {
			return customer;
		} else {
			return null;
		}
	}

	public Account deposit(double amount, int accNo) {
		customer = searchAccount(accNo);
		if (customer == null) {
			return customer;
		} else {
			customer.deposit(amount);
			return customer;
		}
	}

	public int getAccountNo() {
		return Account.getAccountId();
	}

}
