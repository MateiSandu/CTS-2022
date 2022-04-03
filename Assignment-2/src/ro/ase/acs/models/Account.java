package ro.ase.acs.models;

public class Account {
	
	public AccountType accountType;
	
	public double	loan_value,rate;	
	public int	daysActive,account_Type;
	
	public double loan() {
		System.out.println("The loan value is " + this.loan_value);
		return loan_value;
	}
	
	public double getRate() {
		System.out.println("The rate is "+rate);
		return this.rate;
	}
	
	//must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return loan_value*rate;
	}
	
	public void setValue(double value) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loan_value = value;
		}
	}
	
	public String to_string() {
		return "Loan: "+this.loan_value+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+account_Type+";";
	}
	
	public void print() {
		int vb = 10;
		System.out.println("This is an account");
	}

	public static double calculate(Account[] 	accounts)
	{
	double totalFee=0.0;
	Account	account;
	int temp = 365;
	for	(int	i=0;i<accounts.length;i++)	{
	account=accounts[i];
	if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
		totalFee += .0125 * ( // 1.25% broker's fee
		account.loan_value * Math.pow(account.rate, (account.daysActive / 365)) - account.loan_value); // interest-principal
	}
	return	totalFee;
	}

	public Account(double value, double rate, int account_Type) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loan_value = value;
		}
		this.rate = rate;
		this.account_Type = account_Type;
	}
	
	
}
