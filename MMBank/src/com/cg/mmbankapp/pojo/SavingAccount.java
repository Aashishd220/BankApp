package com.cg.mmbankapp.pojo;

public class SavingAccount extends Account{
	private boolean salary;
	private String odLimit="NA";
	
	public SavingAccount(Customer accountHolder, boolean salary,String accountType ) {
		super(accountHolder, accountType);
		this.salary = salary;
	}
	public SavingAccount(Customer accountHolder, double accountBalance, String accountType,boolean salary) {
		super(accountHolder, accountBalance, accountType);
		this.salary = salary;
	}

	public boolean isSalary() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
	}
	@Override
	public String withdraw(double amountToBeWithDrawn) {
		String flag="";
		if(getAccountBalance()>=amountToBeWithDrawn)
		{	System.out.println(getAccountBalance()+"	"+amountToBeWithDrawn);
			setAccountBalance(((getAccountBalance()-amountToBeWithDrawn)));
		flag="yes";
		}else {
			flag="no";
		}
		return flag;
	}
	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
	public String getOdLimit() {
		return odLimit;
	}
	public void setOdLimit(String odLimit) {
		this.odLimit = odLimit;
	}
}
