/**
 * The Alcohol class represents the ALCHCOL beverage
 * @author YLi
 *
 */
public class Alcohol extends Beverage{

	private boolean weekendOffer= false;
	private final double WEEKENDPRICE= 0.6;
	private DAY day;
	
	/**
	 * constructor
	 * @param n Alcohol name
	 * @param s Alcohol name
	 * @param weekendOffer If the alcohol offered by weekend
	 */
	public Alcohol (String n,  SIZE s, boolean weekendOffer) 
	{
		super(n, s);
		this.weekendOffer = weekendOffer;
	}

	/**
	 * Overloaded constructor
	 * @param Alcohol name
	 * @param Alcohol name
	 */
	public Alcohol (String n,  SIZE s) 
	{
		super(n, s);
	}

	
	/**
	 * An overridden abstract method that calculates and returns the beverage price. 
	 * @return the beverage price 
	 */
	@Override
	public double calcPrice() 
	{
		double price=0;
		if (super.getIsWeekend() == true || weekendOffer == true)
			price += WEEKENDPRICE;
		
		if ( super.getSize().equals(SIZE.MEDIUM))
			price += super.getsizePrice();
		else if ( super.getSize().equals(SIZE.LARGE))
			price += super.getsizePrice() *2 ;
		
		price += super.getBasePrice();
		return price;
	}

	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	@Override
	public boolean equals(Alcohol a)
	{
		String size="", s="";
		if (super.getSize().equals(SIZE.SMALL))
			size= "SMALL";
		else if ( super.getSize().equals(SIZE.MEDIUM))
			size= "MEDIUM";
		else if ( super.getSize().equals(SIZE.LARGE))
			size= "LARGE";
		
		if (a.getSize().equals(SIZE.SMALL))
			s= "SMALL";
		else if ( a.getSize().equals(SIZE.MEDIUM))
			s= "MEDIUM";
		else if ( a.getSize().equals(SIZE.LARGE))
			s= "LARGE";
		
		if (weekendOffer == a.weekendOffer && 
			super.getBevName().equals(a.getBevName()) &&
			size== s)
			return true;
		else
			return false;
	}
	
	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	@Override
	public boolean equals (Smoothie a) 
	{
		return false;
	}
	
	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	@Override
	public boolean equals (Coffee a)
	{
		return false;
	}
	
	
	/**
	 * to String method
	 * @return An String representation of a alcohol drink including the name, size, 
	 * 			whether or not beverage is offered in the weekend and the price.
	 */
	@Override
	public String toString()
	{
		String str= "Beverage: "+ super.getType() + " "+ super.getBevName()+ "\nSize: " +
					super.getSize() + "\nOffered in the weekend: " + weekendOffer +
					"\nPrice: " + calcPrice(); 
		
		return str;
	}

	/**
	 * Get the beverage order day
	 * @return the day
	 */
	public DAY getDay() 
	{
		return day;
	}

	/**
	 * Set the beverage order day
	 * @param day  A day that beverage is sold
	 */
	public void setDay(DAY day) 
	{
		this.day = day;
	}

	
	
}
