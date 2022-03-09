package ro.ase.cts.g1099.clean.code.stage2;



// stage 1
// naming conventions! ( we need constant values in the source code)

public class Product {
	public float computeFinalPrice(int productType, float initialPrice, int accountAgeInYears)
	  {
		final int TYPE_NEW = 1;
		final int TYPE_PROMOTION = 2;
		final int TYPE_SALES = 3;
		final int TYPE_FINAL_SALES = 4;
		final int MAX_ACCOUNT_AGE = 10;
		final float MAX_ACCOUNT_DISCOUNT = (float) 0.15;
		final float PROMOTION_DISCOUNT = 0.1f;
		final float SALES_DISCOUNT = 0.25f;
		final float FINAL_SALES_DISCOUNT = 0.35f;
		
	    float finalPrice = 0;
	    float accountDiscount = (accountAgeInYears > MAX_ACCOUNT_AGE) ? MAX_ACCOUNT_DISCOUNT : (float)accountAgeInYears/100; 
	    if (productType == TYPE_NEW)
	    {
	      finalPrice = initialPrice;
	    }
	    else if (productType == TYPE_PROMOTION)
	    {
	      finalPrice = (initialPrice - (PROMOTION_DISCOUNT * initialPrice)) - accountDiscount * (initialPrice - (0.1f * initialPrice));
	    }
	    else if (productType == TYPE_SALES)
	    {
	      finalPrice = (initialPrice - (SALES_DISCOUNT * initialPrice)) - accountDiscount * (initialPrice - (0.25f * initialPrice));
	    }
	    else if (productType == TYPE_FINAL_SALES)
	    {
	      finalPrice = (initialPrice - (FINAL_SALES_DISCOUNT * initialPrice)) - accountDiscount * (initialPrice - (0.35f * initialPrice));
	    }
	    return finalPrice;
	  }
}