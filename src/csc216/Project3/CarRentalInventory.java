package csc216.Project3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class CarRentalInventory implements Inventory 
{	
	CarLinkedList availableCars = new CarLinkedList();
	CarLinkedList reservedCars = new CarLinkedList();
	
	public CarRentalInventory(String file)
	{
		Scanner scan = null;
		String currentLine;
			
		try 
		{
			int invLine = 1;
			File inventoryList = new File(file);
			scan = new Scanner(inventoryList);
			while(scan.hasNext())
			{
				currentLine = scan.nextLine();
				try
				{
				Car newCar = Car.getCarFromString(currentLine, invLine);
				if(newCar.getNumberAvailable() > 0)
				{
					availableCars.insertAvailable(newCar);
				}
				else if(newCar.getNumberReserved() > 0)
				{
					reservedCars.insertReserved(newCar);
				}
				}
				catch(CarDataException cde)
				{
					System.err.println(cde.getMessage());

				}
				finally
				{
					invLine++;
				}
			}
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * Find all items of this kind in the pool of available items
	 *   and return them as an array of Strings. Each element in 
	 *   the array corresponds to an item in the inventory.
	 * @param kind filters the items to be considered.
	 * @return String representing all items of the 
	 *   given kind. 
	 */
	
	@Override
	public String[] availableByKind(int kind) 
	{
		return availableCars.getStringByKind(kind);
	}

	/**
	 * Find all items in the inventory that are reserved and 
	 *   return them as an array of Strings. Each element in the array
	 *   corresponds to a reserved item.
	 * @return String representing all reserved items. 
	 */
	
	@Override
	public String[] reserved() 
	{
		return reservedCars.getStringByKind(0);
	}

	/**
	 * Reserve an item from the pool of available items, filtered
	 * by kind. The item reserved is determined by its position
	 * in the string returned by availableByKind(). 
	 * @param position position (index) of item to be reserved.
	 * @param kind determines which items are considered.
	 */
	
	@Override
	public void reserveItem(int position, int kind) 
	{
		Car[] reserveCar = availableCars.getCarByKind(kind);
		Car carToReserve = reserveCar[position];
		reservedCars.insertReserved(carToReserve);
		availableCars.cleanAvailable(carToReserve);
	}

	/**
	 * A reserved item is returned to the pool of available items, where the item
	 * is determined by its position in the string returned by 
	 *   reserved().
	 * @param position position of the item to be returned.
	 */
	
	@Override
	public void returnItem(int position) 
	{
		Car[] returnCar = reservedCars.getCarByKind(0);
		Car carToReturn = returnCar[position];
		availableCars.insertAvailable(carToReturn);
		reservedCars.cleanReserved(carToReturn);
	}

	/**
	 * Total number of individual available items.
	 * @return the number of available items.
	 */
	
	@Override
	public int totalAvailable() 
	{
		return availableCars.countAvailable();
	}

	/**
	 * Total number of individual reserved items.
	 * @return the number of reserved items.
	 */
	
	@Override
	public int totalReserved() 
	{
		return reservedCars.countReserved();
	}

	public void writeOut()
	{
		Car[] listReserved = reservedCars.getCarByKind(0);
		Car[] listAvailable = availableCars.getCarByKind(0);
		
		try
		{
			String type = "";
			String path = "C:\\CarInventory\\inventory.txt";
			File inventoryFile = new File(path);
			FileWriter copyWriter = new FileWriter(inventoryFile);
			PrintWriter pw = new PrintWriter(copyWriter);
			for(int i = 0; i < listReserved.length; i ++)
			{	
				switch(listReserved[i].getCarKind())
				{		
				case 1: type = "c";
						break;
						
				case 2: type = "m";
						break;
						
				case 3: type = "l";
						break;
				
				case 4: type = "f";
						break;	
						
				case 5: type ="s";
						break;
						
				default: type = "Error";
						break;		
				}
				for(int r = 1; r <= listReserved[i].getNumberReserved(); r++)
					pw.println(type + ", r, " + listReserved[i].getCarMake() + ", " + listReserved[i].getCarModel() + ", " + listReserved[i].getCarColor());
			}
			
			for(int i = 0; i < listAvailable.length; i ++)
				{
				switch(listAvailable[i].getCarKind())
				{		
				case 1: type = "c";
						break;
						
				case 2: type = "m";
						break;
						
				case 3: type = "l";
						break;
				
				case 4: type = "f";
						break;	
						
				case 5: type ="s";
						break;
						
				default: type = "Error";
						break;		
				}
				for(int a = 1; a <= listAvailable[i].getNumberAvailable(); a++)
					pw.println(type + ", a, " + listAvailable[i].getCarMake() + ", " + listAvailable[i].getCarModel() + ", " + listAvailable[i].getCarColor());
				}
			try
			{
				copyWriter.close();			
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(IOException ie)
		{
			
		}
		
		
	}
}
