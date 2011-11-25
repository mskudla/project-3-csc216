package csc216.Project3;

import java.io.File;
import java.io.IOException;
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
				if(newCar.numberAvailable == 1)
				{
					availableCars.insertAvailable(newCar);
				}
				else if(newCar.numberReserved == 1)
				{
					reservedCars.insertReserved(newCar);
				}
				}
				catch(CarDataException cde)
				{
					System.out.println("Error when generating inventory from file.");
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

	public static void main(String[] args)
	{
		CarRentalInventory carInv = new CarRentalInventory("car_data.txt");
//		carInv.availableCars.print();
//		carInv.reservedCars.print();
		String[] carByKind = carInv.availableCars.getStringByKind(0);
			for(int i = 0; i < carByKind.length; i++)
				System.out.println(carByKind[i]);
			carInv.availableCars.print();
			carInv.reservedCars.print();
		
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
	 *   by kind. The item reserved is determined by its position
	 *   in the string returned by availableByKind(). 
	 * @param position position (index) of item to be reserved.
	 * @param kind determines which items are considered.
	 */
	
	@Override
	public void reserveItem(int position, int kind) 
	{
		Car[] reserveCar = availableCars.getCarByKind(kind);
		Car carToReserve = reserveCar[position];
		if(reservedCars.contains(carToReserve))
		{
		
		}

	}

	/**
	 * A reserved item to the pool of available items, where the item
	 *   is determined by its position in the string returned by 
	 *   reserved().
	 * @param position position of the item to be returned.
	 */
	
	@Override
	public void returnItem(int position) 
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Total number of individual available items.
	 * @return the number of available items.
	 */
	
	@Override
	public int totalAvailable() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Total number of individual reserved items.
	 * @return the number of reserved items.
	 */
	
	@Override
	public int totalReserved() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
