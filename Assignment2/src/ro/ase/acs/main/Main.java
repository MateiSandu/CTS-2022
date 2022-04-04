package ro.ase.acs.main;

import ro.ase.acs.models.Account;
import ro.ase.acs.models.AccountType;

public class Main {

	public static void main(String[] args) {

//			This will throw InvalidParameterException!
//		Account ac1 = new Account(AccountType.STANDARD, -3, 123);
		Account ac2 = new Account(AccountType.PREMIUM, 5350.49, 2.75);

		ac2.checkForPremiumAccount();
		ac2.getMonthlyRate();
		ac2.setDaysActive(100);

//			This will throw the associated Custom Exception!
//		ac2.setDaysActive(-1);
//		ac2.setLoanValue(-1);
//		ac2.setRateValue(-1);

		System.out.println(ac2);

	}

}
