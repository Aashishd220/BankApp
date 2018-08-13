package com.cg.mmbankapp.dao;

import java.util.Map;

import com.cg.mmbankapp.pojo.Account;
import com.cg.mmbankapp.pojo.CurrentAccount;
import com.cg.mmbankapp.pojo.SavingAccount;

public interface BankAppDaoInterface {

	void AddNewAccount(Account account);

	void AddNewCurrentAccount(CurrentAccount account);

	void AddNewSavingAccount(SavingAccount account);

	Map<Integer, Account> searchAccount();

	Map<Integer, Account> viewAccount();

	Map<Integer, Account> viewCustomer();

}