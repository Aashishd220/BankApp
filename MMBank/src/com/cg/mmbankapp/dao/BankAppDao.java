package com.cg.mmbankapp.dao;
import java.util.HashMap;
import java.util.Map;
import com.cg.mmbankapp.pojo.Account;
import com.cg.mmbankapp.pojo.CurrentAccount;
import com.cg.mmbankapp.pojo.SavingAccount;

public class BankAppDao implements BankAppDaoInterface {
	static Map<Integer,Account>bankAcc=new HashMap<Integer,Account>();
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#AddNewAccount(com.cg.mmbankapp.pojo.Account)
	 */
	@Override
	public void AddNewAccount(Account account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#AddNewCurrentAccount(com.cg.mmbankapp.pojo.CurrentAccount)
	 */
	@Override
	public void AddNewCurrentAccount(CurrentAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#AddNewSavingAccount(com.cg.mmbankapp.pojo.SavingAccount)
	 */
	@Override
	public void AddNewSavingAccount(SavingAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#searchAccount()
	 */
	@Override
	public  Map<Integer,Account> searchAccount() {
		return bankAcc;
	}
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#viewAccount()
	 */
	@Override
	public  Map<Integer,Account> viewAccount() {
		return bankAcc;
	}
	/* (non-Javadoc)
	 * @see com.cg.mmbankapp.dao.BankAppDaoInterface#viewCustomer()
	 */
	@Override
	public Map<Integer,Account> viewCustomer() {
		return bankAcc;
	}
}
