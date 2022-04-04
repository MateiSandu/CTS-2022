package ro.ase.acs.models;

import ro.ase.acs.interfaces.MonthlyRateInterface;

public class Account implements MonthlyRateInterface {

	private AccountType accountType;
	private double loanValue, rateValue;
	private int daysActive;
	
	public Account(AccountType accountType, double loanValue, double rateValue) throws Exception {
		super();
		if(this.loanValue < 0  || this.rateValue < 0) {
			throw new Exception();
		} else {
			this.accountType = accountType;
			this.loanValue = loanValue;
			this.rateValue = rateValue;
		}
	}
	
	public Account() {
		super();
		this.accountType = AccountType.STANDARD;
		this.loanValue = 0;
		this.rateValue = 0;
		this.daysActive = 0;
	}

	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}

	public void setLoanValue(double loanValue) throws Exception {
		if (this.loanValue < 0)
			throw new Exception();
		else {
			this.loanValue = loanValue;
		}
	}

	public double getRateValue() {
		System.out.println("The rate is " + rateValue);
		return this.rateValue;
	}

	public void setRateValue(double rateValue) throws Exception {
		if (this.rateValue < 0)
			throw new Exception();
		else {
			this.rateValue = rateValue;
		}
	}

	public int getDaysActive() {
		System.out.println("The number of active days is " + this.daysActive);
		return daysActive;
	}

	public void setDaysActive(int daysActive) throws Exception {
		if(this.daysActive < 0) {
			throw new Exception();
		}
		else {
			this.daysActive = daysActive;
		}
	}

	// must have method - the lead has requested it in all classes
	@Override
	public double getMonthlyRate() {
		return loanValue * rateValue;
	}

//	this function relies on the creation of an account
	public static double computeTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account ac;
		for (int i = 0; i < accounts.length; i++) {
			ac = accounts[i];
			if (ac.checkForPremiumAccount() == true)
				totalFee += .0125 * ac.getTotalValue(ac.loanValue, ac.rateValue, ac.daysActive);
		}
		return totalFee;
	}

	public double getTotalValue(double loanValue, double rateValue, int daysActive) {
		return loanValue * Math.pow(rateValue, (daysActive / 365)) - loanValue;
	}

//	function for checking whether an account is premium or not
	public boolean checkForPremiumAccount() {
		if (accountType == AccountType.PREMIUM || accountType == AccountType.SUPER_PREMIUM) {
			return true;
		} else
			return false;
	}

//	StringBuider/StringBuffer
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountType=");
		builder.append(accountType);
		builder.append(", loanValue=");
		builder.append(loanValue);
		builder.append(", rateValue=");
		builder.append(rateValue);
		builder.append(", daysActive=");
		builder.append(daysActive);
		builder.append("]");
		return builder.toString();
	}
}
