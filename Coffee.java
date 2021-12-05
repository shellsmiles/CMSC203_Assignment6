/**
 * The Coffee class represents the COFFEE beverage
 * @author YLi
 *
 */

public class Coffee extends Beverage 		
{
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRAPRICE= 0.5;
	
	/**
	 * constructor
	 * @param n Coffee name
	 * @param s Coffee size
	 * @param shoot If the alcohol contains an extraShoot
	 * @param syrup If the alcohol contains an extraSyrup
	 */
	public Coffee ( String name, SIZE size, boolean shoot, boolean syrup) 
	{
		super (name,  size);
		extraShot= shoot;
		extraSyrup= syrup;
	}

	/**
	 * An overridden abstract method that calculates and returns the beverage price. 
	 * @return the beverage price 
	 */
	@Override
	public double calcPrice() 
	{
		double price=0;
		try
		{
		if (extraShot == true )
			price += EXTRAPRICE;
		if ( extraSyrup== true)
			price += EXTRAPRICE;
		if ( super.getSize().equals(SIZE.MEDIUM))
			price += super.getsizePrice();
		else if ( super.getSize().equals(SIZE.LARGE))
			price += super.getsizePrice() *2 ;
		}
		catch (RuntimeException e)
		{
			System.out.println("The price would be wrong");
		}
		price += super.getBasePrice();
		
		return price;
		
	}
	
	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	@Override
	public boolean equals (Coffee a) 
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
		
		if (extraShot== a.extraShot   && extraSyrup == a.extraSyrup && 
			super.getBevName().equals(a.getBevName()) && size.equals(s))
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
	public boolean equals (Alcohol a)
	{
		return false;
	}
	
	
	
	/**
	 * to String method
	 * @return a String representation of Coffee beverage, including the name, size ,  
	 * 			whether it contains extra shot, extra syrup and the price of the coffee
	 */
	@Override
	public String toString()
	{
		String s="";
		if (super.getSize().equals(SIZE.SMALL))
			s="SMALL";
		else if (super.getSize().equals(SIZE.MEDIUM))
			s="MEDIUM";
		else if (super.getSize().equals(SIZE.LARGE))
			s="LARGE";
		
		String str= "Beverage: "+   super.getBevName()+ "\nSize: " + s +
					"\nExtra Shoot" + extraShot +
					+ calcPrice();
	
		return str;
		
	}

	/**
	 * Get if an coffee drink contains an extraShot
	 * @return a boolean
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	/**
	 * Get if an coffee drink contains an extraSyrup
	 * @return a boolean
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	
}
