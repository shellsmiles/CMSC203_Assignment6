/**
 * The Customer class represents a customer 
 * @author y
 *
 */
public class Customer {
	
	private int customerAge;
	private String customerName;
	
	/**
	 * Constructor
	 * @param name The customer's name
	 * @param age The customer's age
	 */
	public Customer (String name, int age)
	{
		customerName = name;
		customerAge = age;
	}
	
	/**
	 * Copy constructor
	 * @param itself  Customer class object
	 */
	public Customer (Customer itself )
	{
		this.customerAge= itself.customerAge;
		this.customerName= itself.customerName;
	}
	
	/**
	 * Get the customer's age
	 * @return the age
	 */
	public int getAge() {
		return customerAge;
	}

	/**
	 * Set the customer's age
	 * @param age the customer's age
	 */
	public void setAge(int age) {
		customerAge = age;
	}

	/**
	 * Get the customer's name
	 * @return the name
	 */
	public String getName() {
		return customerName;
	}

	/**
	 * Set the customer's name
	 * @param name  the customer's name
	 */
	public void setName(String name) {
		customerName = name;
	}

	/**
	 * toString method
	 * @return A String representation for Customer including the name and age
	 *			getters and setters  and any other methods that are needed for your design.  
	 */
	public String toString ()
	{
		String str= "Customer Name: "+ customerName + "\nAge: " +customerAge;
		return str;
	}
	
}

