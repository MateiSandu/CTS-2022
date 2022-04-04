package ro.ase.acs.models;

	public class Account {
		public AccountType accountType;
		public double loanValue, rateValue;	
		public int	daysActive;
		
		public double getLoanValue() {
			System.out.println("The loan value is " + this.loanValue);
			return loanValue;
		}
		
		public double getRateValue() {
			System.out.println("The rate is "+rateValue);
			return this.rateValue;
		}
		
		//must have method - the lead has requested it in all classes
		public double getMonthlyRate() {
			return loanValue*rateValue;
		}
		
		public void setValue(double value) throws Exception {
			if(value<0)
				throw new Exception();
			else
			{
				loanValue = value;
			}
		}
		
		public String to_string() {
			return "Loan: "+this.loanValue+"; rate: "+this.rateValue+"; days active:"+daysActive+"; Type: "+accountType+";";
		}

		public static double computeTotalFee(Account[] 	accounts)
		{
		double totalFee=0.0;
		Account	instance;
		for	(int	i=0;i<accounts.length;i++)	{
		instance=accounts[i];
		if (instance.accountType == AccountType.PREMIUM || instance.accountType == AccountType.SUPER_PREMIUM)
		totalFee+=.0125	*	(	//	1.25%	broker's	fee
				instance.loanValue*Math.pow(instance.rateValue,(instance.daysActive/365)) - instance.loanValue);	//	interest-principal
		}
		return	totalFee;
		}

		public Account(double value, double rate, AccountType account_Type) throws Exception {
			if(value<0)
				throw new Exception();
			else
			{
				loanValue = value;
			}
			this.rateValue = rate;
			this.accountType = account_Type;
		}
		
		
	}
