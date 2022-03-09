package ro.ase.cts.g1099.clean.code.stage3;

// stage 1
// naming conventions! ( we need constant values in the source code)
// magic numbers (constant values in the source code)

// stage 2
// using enums
// enums are classed in java

public class Product {
	public float computeFinalPrice(ProductType productType, float initialPrice, int accountAgeInYears) {
//		SOURCE -> FORMAT TO REARRANGE CODE
		final int MAX_ACCOUNT_AGE = 10;
		final float MAX_ACCOUNT_DISCOUNT = (float) 0.15;


		float finalPrice = 0;
		float accountDiscount = (accountAgeInYears > MAX_ACCOUNT_AGE) ? MAX_ACCOUNT_DISCOUNT
				: (float) accountAgeInYears / 100;
		if (productType == ProductType.NEW) {
			finalPrice = initialPrice;
		} else if (productType == ProductType.DISCOUNT) {
			finalPrice = (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice))
					- accountDiscount * (initialPrice - (ProductType.DISCOUNT.getDiscount() * initialPrice));
		} else if (productType == ProductType.SALES) {
			finalPrice = (initialPrice - (ProductType.SALES.getDiscount() * initialPrice))
					- accountDiscount * (initialPrice - (ProductType.SALES.getDiscount() * initialPrice));
		} else if (productType == ProductType.FINAL_SALES) {
			finalPrice = (initialPrice - (ProductType.FINAL_SALES.getDiscount() * initialPrice))
					- accountDiscount * (initialPrice - (ProductType.FINAL_SALES.getDiscount() * initialPrice));
		}
		return finalPrice;
	}
}