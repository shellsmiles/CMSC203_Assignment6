/**
 * The superclass for three kinds of beverage
 * @author YLi
 */

public abstract class Beverage {

	private String bevName;
	private TYPE type;
	private SIZE size;
	private final double BASEPRICE= 2.0;
	private final double SIZEPRICE= 1.0;
	private boolean isWeekend= false;
	
	
	/**
	 * Constructor
	 * @param n Beverage name
	 * @param t Beverage type
	 * @param s Beverage size
	 */
	public Beverage ( String n, TYPE t, SIZE s ) {
		bevName = n;
		type = t;
		size = s;
	}
	
	/**
	 * Overloaded constructor 
	 * @param n Beverage name
	 * @param s Beverage size
	 */
	public Beverage ( String n , SIZE s ) {
		bevName = n;
		size = s;
	}
	
	/**
	 * Check if the beverage is available
	 * @param day Order day
	 */
	public void isWeekend(DAY day)
	{
		if (day.equals(DAY.SATURDAY) || day.equals(DAY.SUNDAY))
			isWeekend= true;
	}
	
	/**
	 * Get if the beverage is available on weekends
	 * @return a boolean
	 */
	public boolean getIsWeekend()
	{
		return isWeekend;
	}
	
	/**
	 * An abstract method that calculates and returns the beverage price. 
	 */
	public abstract double calcPrice ();
	
	/**
	 * An abstract method that checks equality based on name, type, size of the beverage
	 */
	public abstract boolean equals (Coffee a);
	
	/**
	 * An abstract method that checks equality based on name, type, size of the beverage
	 */
	public abstract boolean equals (Smoothie a);
	
	/**
	 * An abstract method that checks equality based on name, type, size of the beverage
	 */
	public abstract boolean equals (Alcohol a);
	
	/**
	 * Get the beverage size
	 * @return size
	 */
	public SIZE getSize()
	{
		return size;
	}
	
	/**
	 * Get the base price of the beverage
	 * @return the base price
	 */
	public double getBasePrice() 
	{
		return BASEPRICE;
	}
	
	/**
	 * Get the price for adding size 
	 * @return  the price for adding size 
	 */
	public double getsizePrice() 
	{
		return SIZEPRICE;
	}

	/**
	 * Get the beverage name
	 * @return the beverage name
	 */
	public String getBevName()
	{
		return bevName;
	}
	
	/**
	 * Get the beverage type
	 * @return the beverage type
	 */
	public TYPE getType()
	{
		return type;
	}
	
	/**
	 * Set the beverage type
	 */
	public void setType(TYPE type)
	{
		this.type= type;
	}
	
	/**
	 * An toString method
	 * @return An String representation for Beverage including the name and size
	 */
	public String toString () 
	{
		return bevName + size + " ";
	}

}
