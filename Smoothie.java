/**
 * The Smoothie class represents the SMOOTHIE beverage
 * @author YLi
 */

public class Smoothie extends Beverage{

	private int numOfFruits;
	private boolean addProtein;
	private final double FRUITSPRICE= 0.5;
	private final double PROTEINPRICE= 1.5;
	
	/**
	 * constructor
	 * @param n A smoothie name
	 * @param s A smoothie size
	 * @param numFruits If the smoothie contains fruits
	 * @param addPro If the smoothie contains protein powder
	 */
	public Smoothie(String n,  SIZE s, int numFruits, boolean addPro) {
		super(n, s);
		numOfFruits= numFruits;
		addProtein = addPro;
		
	}

	/**
	 * An overridden abstract method that calculates and returns the beverage price. 
	 * @return the beverage price 
	 */
	@Override
	public double calcPrice() {
		
		double price=0;
		if ( super.getSize().equals(SIZE.MEDIUM))
			price += super.getsizePrice();
		else if ( super.getSize().equals(SIZE.LARGE))
			price += super.getsizePrice() *2 ;
		
		
		if (addProtein == true)
			price += PROTEINPRICE;
		
		price += super.getBasePrice() + numOfFruits * FRUITSPRICE;
		return price;
	}

	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	@Override
	public boolean equals (Smoothie a) 
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
		
		if (numOfFruits== a.getNumOfFruits() &&
		   addProtein == a.addProtein &&
		   super.getBevName().equals(a.getBevName()) &&
		   size.equals(s))
		   return true;
	    else 
		   return false;
		
	}
	
	
	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	public boolean equals (Coffee a)
	{
		return false;
	}
	
	/**
	 * An overridden abstract method that checks equality based on name, type, size of the beverage
	 * @return a boolean
	 */
	public boolean equals (Alcohol a)
	{
		return false;
	}
	
	/**
	 * Get the number of fruits in the smoothie
	 * @return the number
	 */
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	
	/**
	 * Get if the smoothie contain protein powder
	 * @return a boolean
	 */
	public boolean getAddProtien() {
		
		return addProtein;
	}
	
	
	
	/**
	 * toStirng method
	 * @return A String representation of a Smoothie drink including the name, size, 
	 * 			whether or not protein is added , number of fruits and the price
	 */
	@Override
	public String toString()
	{
		String str= "Beverage: "+ super.getType() + " "+ super.getBevName()+ "\nSize: " +
					super.getSize() + "\nnumber of fruits: " + numOfFruits +"\nAdding protein: "+ 
					addProtein + "\nPrice: " + calcPrice();
	
		return str;
	}


}
