package csc216.Project3;

public class Car implements RentalItem 
{
	private static final int ALLCARS = 0;
	private static final int COMPACT = 1;
	private static final int MIDSIZE = 2;
	private static final int LARGE = 3;
	private static final int FUN = 4;
	private static final int SUV = 5;
	private static final String[] carKindArray = {"All", "Compact","Midsize","Large","Fun", "SUV"};

	private String description;
	private String stringKind;
	private boolean stringAvail;
	private String stringMake;
	private String stringModel;
	private String stringColor;
	private String carMake, carModel, carColor;
	private int carKind, numberAvailable, numberReserved;
	private boolean statusOfAvail;
	private static String[] token;
	private static Car newCar;

	
//	public Car(String kind, String make, String model, String color)
//	{
//	
//		
//	}

/**
 * Gets the description of the item.
 * @return a string representation of the item.
 */
	@Override
	public String getDescription() 
	{
		description = this.carMake + " " + this.carModel + " -- " + this.carColor;
		return description;
	}

	/**
	 * Is this item  available?
	 * @return true if the item is available, false otherwise.
	 */
	@Override
	public boolean isAvailable() 
	{
		if(this.numberReserved < this.numberAvailable + this.numberReserved)
		{
			return true;
		}
		return false;
	}

	/**
	 * Place the item on reserve.
	 */
	@Override
	public void reserve() 
	{
		this.numberReserved++;
	}

	/**
	 * Make this item available.
	 */
	@Override
	public void returnToInventory() 
	{
		this.numberAvailable++;		
	}
	
	public void removeFromInventory()
	{
		this.numberAvailable--;
	}
	
	public void removeFromReserved()
	{
		this.numberReserved--;
	}

	/**
	 * What is the "kind" of the item.
	 * @return the item kind.
	 */
	@Override
	public int getKind() 
	{
		return this.carKind;
	}

	/**
	 * Returns a car from the line in the text file specified.
	 * @param line - the text at the specified line number
	 * @param lineNumber - the number of the line the text to create the car from is on
	 * @return newCar - a car object with it's variables filled in from the info on the line
	 * @throws CarDataException - the error message to throw if there is a car parse error
	 */
	public static Car getCarFromString(String line, int lineNumber) throws CarDataException
	{
		token = line.split(",");
		if(token.length != 5)
		{
			throw new CarDataException("Bad data on line: " + lineNumber);
		}
		
		newCar = new Car();
		
		for(int i = 0; i < token.length; i++)
		{
			token[i] = token[i].trim();
		}
		
		if(token[0].equalsIgnoreCase("c"))
		{
			newCar.carKind = 1;
		}
		else if(token[0].equalsIgnoreCase("m"))
		{
			newCar.carKind = 2;
		}
		else if(token[0].equalsIgnoreCase("l"))
		{
			newCar.carKind = 3;
		}
		else if(token[0].equalsIgnoreCase("f"))
		{
			newCar.carKind = 4;
		}
		else if(token[0].equalsIgnoreCase("s"))
		{
			newCar.carKind = 5;
		}
		else
			throw new CarDataException("Bad car kind on line: " + lineNumber);
		
		
		if(token[1].equalsIgnoreCase("a"))
		{
			newCar.numberAvailable++;
		}
		else if(token[1].equalsIgnoreCase("r"))
		{
			newCar.numberReserved++;
		}
		else
			throw new CarDataException("Bad reserved status on line: " + lineNumber);
		
		newCar.carMake = token[2];
		newCar.carModel = token[3];
		newCar.carColor = token[4];
		return newCar;
	}
	
	public int compareTo(Car compareCar)
	{
		return this.getDescription().compareTo(compareCar.getDescription());
	}
	
	public void setNumberReserved(int number)
	{
		this.numberReserved = number;
	}
	public int getNumberReserved()
	{
		return this.numberReserved;
	}
	
	public void setNumberAvailable(int number)
	{
		this.numberAvailable = number;
	}
	
	public int getNumberAvailable()
	{
		return this.numberAvailable;
	}
	
	public int removeOneReserved()
	{
		this.numberReserved--;
		return this.numberReserved;
	}
	
	public int addOneReserved()
	{
		this.numberReserved++;
		return this.numberReserved;
	}
	
	public int addOneAvailable()
	{
		this.numberAvailable++;
		return this.numberAvailable;
	}
	
	public int removeOneAvailable()
	{
		this.numberAvailable++;
		return this.numberAvailable;
	}
	
	public int getCarKind()
	{
		return this.carKind;
	}
	
	public String getCarMake()
	{
		return this.carMake;
	}
	
	public String getCarModel()
	{
		return this.carModel;
	}
	
	public String getCarColor()
	{
		return this.carColor;
	}
}
