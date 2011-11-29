package csc216.Project3;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarRentalInventoryTest 
{
	CarRentalInventory cri;

	@Before
	public void setUp() throws Exception 
	{
		cri = new CarRentalInventory("car_test.txt");
	}

	public String concatonateString(String[] array)
	{
		String megaString = "";
		for(int i = 0; i < array.length; i++)
		{
			megaString += array[i] + ", ";
		}
		return megaString;
	}
	
	@Test
	public void testReserved()
	{
		assertEquals("X X -- X, A A -- A, ", concatonateString(cri.reserved()));
		
	}
	
	@Test
	public void testAvailableByKind0()
	{
		
	assertEquals("B B -- B, X T -- T, X X -- X, Y Y -- Y, ", concatonateString(cri.availableByKind(0)));
	}
	
	@Test 
	public void testAvaialableByKind3()
	{
		assertEquals("B B -- B, X T -- T, ", concatonateString(cri.availableByKind(3)));
	}
	
	@Test 
	public void testReserveItemFirstAvailable()
	{
		cri.reserveItem(0,0); 
		assertEquals("X T -- T, X X -- X, Y Y -- Y, ", concatonateString(cri.availableByKind(0)));
	}
	
	@Test 
	public void testReserveItemFirstReserved()
	{
		cri.reserveItem(0,0);
		assertEquals("B B -- B, X X -- X, A A -- A, ", concatonateString(cri.reserved()));
	}
	
	@Test 
	public void testReserveItemLast()
	{
		cri.reserveItem(cri.totalAvailable() -1, 0);
		assertEquals("B B -- B, X T -- T, X X -- X, ", cri.availableByKind(0));
	}
	
	@Test
	public void testReserveItemMatch()
	{
		cri.reserveItem(2,0);
		assertEquals("X X -- X, A A -- A, ", concatonateString(cri.reserved()));
	}
	
	@Test
	public void testReserveItemNonZeroFilter()
	{
		cri.reserveItem(0,3);
		assertEquals("X X -- X, A A -- A, B B -- B, ", concatonateString(cri.reserved()));
		
	}
	
	@Test
	public void testRetrunFirstAvaialble()
	{
		cri.returnItem(0);
		assertEquals("B B -- B, X T -- T, X X -- X, Y Y -- Y, ", concatonateString(cri.availableByKind(0)));
	}
	
	@Test 
	public void testReturnFirstReserved()
	{
		cri.reserveItem(0,0);
		assertEquals("X X -- X, A A -- A, ", concatonateString(cri.reserved()));
	}
	
	@Test
	public void testReturnSecond()
	{
		
	}
	
	@Test
	public void testTotalAvailable()
	{
		assertEquals(4, cri.totalAvailable());
	}
	
	@Test
	public void testTotalReserved()
	{
		assertEquals(3, cri.totalReserved());
	}
}
