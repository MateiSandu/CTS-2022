package ro.ase.acs.main;

import ro.ase.acs.models.Account;
import ro.ase.acs.models.AccountType;

public class Main {

	public static void main(String[] args) {
		try {
			Account ac1 = new Account(AccountType.SUPER_PREMIUM, 1.75, 3200);
			ac1.setDaysActive(399);
//			System.out.println(ac1.getRateValue());
			
			if(ac1.checkForPremiumAccount() == true) 
				System.out.println("Premium/Super-Premium account");

			
			System.out.println(ac1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
