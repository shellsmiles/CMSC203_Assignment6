/**
 * The Order class represents a order
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioFileFormat.Type;


public class Order implements OrderInterface, Comparable{
	private int orderNum;
	private int time;
	private DAY day;
	private String customerName;
	private int customerAge;
	private ArrayList <Beverage> bevList = new ArrayList <Beverage>();
	private Customer customer;
	private Order order;
	private double totalPrice=0;
	
	Scanner kb= new Scanner(System.in);
	
	/**
	 * Constructor
	 * @param t The order time
	 * @param d The order day
	 * @param c The order's customer object
	 */
	public Order ( int t, DAY d, Customer c )
	{
		time= t;
		day= d;
		customer= new Customer (c);
		customerName= customer.getName();
		customerAge= customer.getAge();
		setOrderNo();
	}
	
	
	/**
	 * An overloaded constructor
	 * @param time The order time
	 * @param day  The order day
	 * @param customerName  The order's customer name
	 * @param customerAge	The order's customer age
	 */
	public Order (int time, DAY day,
					String customerName, int customerAge)
	{ 
		this.time= time;
		this.day= day;
		this.customerName = customerName;
		this.customerAge= customerAge;
	}
	
	
	/**
	 * Copy constructor
	 * @param o The Order Class object
	 */
	public Order ( Order o)
	{
		order= new Order (o);
		this.day = order.day;
		this.orderNum= order.getOrderNo();
		this.time= order.time;
		this.customerName= order.getCustomerName();
		this.customerAge = order.getCustomerAge();
		this.totalPrice= order.calcOrderTotal();
		this.customer= order.getCustomer();
		
		for(int i=0; i<bevList.size(); i++)
		{
			this.bevList.get(i).equals(order.bevList.get(i));
		}
		setOrderNo();
	}
	
	
	/** 
	 * Get the order time
	 * @return the time
	 */
	public int getTime() {
		return time;
	}


	/** 
	 * Get the order customer's age
	 * @return the customerAge
	 */
	public int getCustomerAge() {
		return customerAge;
	}

	
	/**
	 * Get the customer's name
	 * @return the customer's name
	 */
	public String getCustomerName()
	{
		return customerName;
	}
	
	
	/**
	 * Get Customer class object
	 * @return A Customer class object
	 */
	public Customer getCustomer()
	{
		return new Customer( customer.getName(), customer.getAge() );
	}
	
	
	/**
	 * Get total items in a order
	 * @return the total items of a beverage list
	 */
	public int getTotalItems()
	{
		return bevList.size();
	}
	
	/**
	 * Get the order time
	 * @return the order time
	 */
	public int getOrderTime()
	{
		return time;
	}
	
	/**
	 * Get the order day
	 * @return the order day
	 */
	public DAY getOrderDay()
	{
		return day;
	}

	
	/**
	 * Set the order number: random order number
	 */
	public void setOrderNo()
	{
		Random rd= new Random();
		orderNum= rd.nextInt(80001)+10000;
	}
	
	/**
	 * Get the order number
	 * @return the order number
	 */
	public int getOrderNo()
	{
		return orderNum;
	}
	
	
	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(
				String bevName,
				SIZE size,
				boolean extraShot,
				boolean extraSyrup) 
	{
		bevList.add( new Coffee( bevName, size, extraShot, extraSyrup)) ;
		bevList.get(bevList.size()-1).setType(TYPE.COFFEE);
	}
	
	
	
	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void addNewBeverage( String bevName,
								SIZE size) 
	{
		
		bevList.add( new Alcohol (bevName, size)) ;
		bevList.get(bevList.size()-1).setType(TYPE.ALCOHOL);
		if (isWeekend()== true)
			bevList.get(bevList.size()-1).isWeekend(day);
	}
	
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addPRotien true if protein is added, false otherwise
	 */
	public void addNewBeverage( String bevName,
				SIZE size,
				int numOfFruits,
				boolean addProtien) 
	{
		bevList.add( new Smoothie (bevName, size, numOfFruits, addProtien));
		bevList.get(bevList.size()-1).setType(TYPE.SMOOTHIE);
	}
	
	
	/**
	 * 
	 * @param day the day of the week
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	 public boolean isWeekend() 
	{
		if( day.equals(DAY.SATURDAY)|| day.equals(DAY.SUNDAY))
			return true;
		else
			return false;
	}

	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * @param itemNo the index position
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	@Override
	 public Beverage getBeverage (int itemNo) {
		return bevList.get(itemNo);
	}
	
	/**
	 * Get the beverage list
	 * @return the beverage list
	 */
	public ArrayList<Beverage> bevL ()
	{
		return bevList;
	}
	
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() 
	{
		double temp=0;
		for (int i=0; i< bevList.size(); i++)
			temp += bevList.get(i).calcPrice();
		totalPrice= temp;
		return totalPrice;
	}
	
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(TYPE type) 
	{
		int count=0;
		for (int i=0; i< bevList.size(); i++)
		{
			if (bevList.get(i).getType().equals(type))
				count++;
		}
		return count;	
	}
	
	/**
	 * An Overridden toString method
	 * @return Includes order number, time, day, customer name , customer age and the list 
	 * 			of beverages (with information of the beverage).
	 */
	@Override
	public String toString()
	{
		
		String str= "OrderNumber: " + orderNum + 
				"\nOrder time: " + time + " "+ day + 
				"\nCustomer Name: " + customerName + " " +customerAge +
				"\nBeverage List: \n";
		
		for (int i=0; i< bevList.size(); i++)
		{
			String type="", size="";
			if (bevList.get(i).getType().equals(TYPE.COFFEE))
				type= "COFFEE";
			else if (bevList.get(i).getType().equals(TYPE.SMOOTHIE))
				type= "SMOOTHIE";
			else if (bevList.get(i).getType().equals(TYPE.ALCOHOL))
				type= "ALCOHOL";
			
			if (bevList.get(i).getSize().equals(SIZE.SMALL))
				size= "SMALL";
			else if (bevList.get(i).getSize().equals(SIZE.MEDIUM))
				size= "MEDIUM";
			else if (bevList.get(i).getSize().equals(SIZE.LARGE))
				size= "LARGE";
			
			str += type + " " + bevList.get(i).getBevName() + 
					" " + size + 
					" " + bevList.get(i).calcPrice()+
					getCustomer().getName() ;
		}
		
		str+= "Order total: " + calcOrderTotal();
		return str;
	}
	
	
	
	/**
	 * An Override the compareTo method to compare this order with another order based on the order number.
	 * @return 	Returns 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, 
	 * 			-1 if it smaller than another order's order number. 
	 */
	@Override
	public int compareTo (Object o) {
		int result = -100; 
		if (orderNum == ((Order) o).getOrderNo())
			result= 0;
		else if ( orderNum < ((Order) o).getOrderNo())
			result= -1;
		else if ( orderNum > ((Order) o).getOrderNo())
			result= 1;
		return result;
	}
	
	
}


