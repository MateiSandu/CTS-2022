package ro.ase.acs.models;

public enum AccountType {
		
	STANDARD(0, 0), BUDGET(1,0), PREMIUM(2, .0125f), SUPER_PREMIUM(3, .0125f);
	
	int type;
	float totalFee;

	private AccountType(int type, float totalFee) {
		this.type = type;
		this.totalFee = totalFee;
	}

	public int getType() {
		return type;
	}

	public float getTotalFee() {
		return totalFee;
	}
	
}
