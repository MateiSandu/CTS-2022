package ro.ase.acs.models;

public enum AccountType {
	
//	Use enums instead of int constants
	STANDARD(0), BUDGET(1), PREMIUM(2), SUPER_PREMIUM(3);
	
	int type;

	private AccountType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
}