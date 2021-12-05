/**
 * This class operates the shop's orders.
 * @author YLi
 */
import java.util.ArrayList;

public class BevShop implements BevShopInterfce{

	private Order currentOrder;
	private final int NUMOFALC= 3;
	private final int VALIDAGE =21;
	private int minTime=8;
	private int maxTime=23;
	private Customer customer;
	private ArrayList <Order> orderList = new ArrayList <Order>();
	private int time;
	private DAY day;
	private int listSize;
	
	public BevShop()
	{
		
	}
	
	
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @param time time represents the time 
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean validTime(int time)
	{
		if (time >= minTime && time <= maxTime)
			return true;
		else 
			return false;
	}
	

	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean eligibleForMore()
	{
		boolean more= true;
		if ( currentOrder.findNumOfBeveType(TYPE.ALCOHOL)== NUMOFALC)
			more= false;

		return more;
	}
	
	/**
	 * check the valid age for the alcohol drink
	 * @param age the age  
	 * @return returns true if age is more than minimum eligible age , false otherwise  
	 */
	@Override
	public boolean validAge(int age)
	{
		if ( age> VALIDAGE)
			return true;
		else
			return false;
	}
	
	
	
	/**
	  * Creates a new order ,  NO BEVERAGE is added to the order yet 
	  * @param time time of the order  
	  * @param day day of the order of type DAY
	  * @param customerName customer name 
	  * @param customerAge customer age
	  */
	@Override
	public void startNewOrder(int time,
						 	DAY day,
						 	String customerName,
						 	int customerAge)
	{
		
		customer= new Customer (customerName,customerAge);
		currentOrder= new Order (time, day, customer);
		
		orderList.add ( currentOrder );
		listSize= orderList.size();
		//orderList.add ( new Order (time, day, customerName, customerAge));
	}
	
	/**
	 * Get the current Order
	 * @return the current order
	 */
	public Order getCurrentOrder()
	{
		return orderList.get(orderList.size()-1);
	}
	
	
	
	/**
	 * process the Coffee order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder( String bevName,
									SIZE size,
									boolean extraShot,
									boolean extraSyrup )
	{
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		//orderList.get(orderList.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}
		
		
	/**
	 * process the Alcohol order for the current order by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 */
	@Override
	public void  processAlcoholOrder( String bevName,
									SIZE size )
	{
		currentOrder.addNewBeverage(bevName, size);
		//orderList.get(orderList.size()-1).addNewBeverage(bevName, size);
	}
	
	
	
	
	/**
	 * process the Smoothie order for the current order  by adding it to the current order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits to be added 
	 * @param addProtien true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder( String bevName,
									SIZE size,
									int numOfFruits,
									boolean addProtien)
	{
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
		//orderList.get(orderList.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	
	
	/**
	 * locate an order based on  the order number
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders if found or -1 if not found
	 */
	@Override
	public int findOrder(int orderNo)
	{
		
		int index= -1;
		int i;
		for ( i=0 ; i< orderList.size(); i++)
		{
			if (orderList.get(i).getOrderNo() == orderNo)
				index=i;
		}
		return index;
	}			
	
	
	/**
	 * locates an order in the list of orders and returns the total value on the order.
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	@Override	
	public double totalOrderPrice(int orderNo)
	{
		double totalOrderPrice=0; 
		for (int i=0; i< orderList.size(); i++)
		{
			if (orderList.get(i).getOrderNo()== orderNo)
				totalOrderPrice= orderList.get(i).calcOrderTotal();
		}
		return totalOrderPrice;
		
	}
	
	
	
	/**
	 *  Calculates the total sale of all the orders for this beverage shop
	 *  @return the total sale of all the orders 
	 */
	@Override
	public double totalMonthlySale()   
	{
		double totalSales = 0;
		for (int i=0; i< orderList.size(); i++)
		{
			totalSales += orderList.get(i).calcOrderTotal();
		}
		return totalSales;
	}
	
	
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	@Override
	public  void sortOrders()
	{
		int min;
		int minIndex;
		
		for( int i=0; i< orderList.size()-1; i++)
		{
			min= orderList.get(i).getOrderNo();
			minIndex=i ;
			
			for (int j= i + 1; j< orderList.size(); j++)
			{
				if (orderList.get(j).getOrderNo()< min)
				{
					min= orderList.get(j).getOrderNo();
					minIndex= j ;
				}
			}
			
			orderList.add(i,orderList.get(minIndex));
			orderList.remove(minIndex+1);
		}
		
		
		// Another way to sort the orderList
		/* 	 
		int min= 999999999;
		int minIndex=0;
		ArrayList <Order> temp= new ArrayList<>();
		while(orderList.size() !=0)
		{
			if (orderList.size()>0 )
			{
				for (int i=0; i< orderList.size(); i++)
				{
					if (orderList.get(i).getOrderNo() < min)
					{
						min =orderList.get(i).getOrderNo();
						
						minIndex= i;
					}
				}
				temp.add( orderList.get(minIndex));
				orderList.remove(minIndex);
				min= 999999999;
			}
		}
		
		for( Order item: temp )
		{
			orderList.add(item);
		}*/
		
	}
	
	
	
	/**
	 * Get the total number of monthly orders
	 * @return the number of monthly orders
	 */
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
		
	}

	/**
	 * If a smoothie has ordered the maximum number of fruit 
	 * @param i  The number of  fruit that has added
	 * @return yes There is no any fruits can be added, no There can add extra fruits
	 */
	public boolean isMaxFruit(int i) {
		
		boolean result= false;
		
		int maxFruit= 6;
		if (i == maxFruit)
			result= true;
		return result;
	}

	/**
	 * Get the number of Alcohol drink in a order
	 * @return The number of Alcohol drink in a order
	 */
	public int getNumOfAlcoholDrink ()
	{ 
		int newOrder= orderList.size()-1;
		int numOfAlcohol= orderList.get( newOrder ).findNumOfBeveType(TYPE.ALCOHOL);
		return numOfAlcohol;
	}

	/**
	 * Get the information of an order's customer
	 * @return Customer class object
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Get the max number for ordering Alcohol drink
	 * @return the max number  
	 */
	public int getMaxOrderForAlcohol() {
		
		return NUMOFALC;
	}

	/**
	 * Get the minimum age for ordering Alcohol drink
	 * @return the minimum age
	 */
	public int getMinAgeForAlcohol() {
		
		return VALIDAGE;
	}


	/**
	 * returns Order in the list of orders at the index
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index 
	 */
	@Override
	public Order getOrderAtIndex(int index)
	{
		return orderList.get(index);
	}
	
	/**
	 * The class toString method
	 * @return a string representation of all the orders and the total monthly sale
	 */
	public String toString()
	{
		String str1= "", str2="";
		for (int i=0; i< orderList.size(); i++)
		{
			str1 += "OrderNumber: " + orderList.get(i).getOrderNo()+ "\n" +
					"Customer Name: " +orderList.get(i).getCustomer().getName() ;
			
			for (int j=0; j < orderList.get(i). bevL().size(); j++ )
			{
				str2 += orderList.get(i).getBeverage(j).getSize().toString()+ 
						orderList.get(i).getBeverage(j).getBevName();
			}	
		}
		
		return str1+ str2+ totalMonthlySale();
		
	}


	
}	
	
	

