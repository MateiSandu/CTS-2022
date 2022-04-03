package ro.ase.acs.models;

public class Account {

	public AccountType accountType;
	public int daysActive;
	public double loanValue, rateValue;
	
	
	public Account(AccountType accountType, double loanValue, double rateValue) throws Exception{
		super();
		if(loanValue < 0)
			throw new Exception();
		else {
			this.loanValue = loanValue;
		}
		this.accountType = accountType;
		this.rateValue = rateValue;
	}

	public Account() {
		this.accountType = AccountType.STANDARD;
		daysActive = 0;
		loanValue = 0;
		rateValue = 0;
	}

	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return loanValue;
	}
	
	public double getRateValue() {
		System.out.println("The rate is " + rateValue);
		return rateValue;
	}
	
	public void setLoanValue(double loanValue) throws Exception {
		if (loanValue < 0)
			throw new Exception();
		else
			this.loanValue = loanValue;
	}

	// must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return loanValue * rateValue;
	}

	public static double computeTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
				totalFee += .0125 * ( // 1.25% broker's fee
				account.loanValue * Math.pow(account.rateValue, (account.daysActive / 365)) - account.loanValue); // interest-principal
		}
		return totalFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountType=");
		builder.append(accountType);
		builder.append(", daysActive=");
		builder.append(daysActive);
		builder.append(", loanValue=");
		builder.append(loanValue);
		builder.append(", rateValue=");
		builder.append(rateValue);
		builder.append("]");
		return builder.toString();
	}

	
}
