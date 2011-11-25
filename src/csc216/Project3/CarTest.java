package csc216.Fall2011.Project3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
Car testCar;
Car lesserCar;
Car equalCar;

	@Before
	public void setUp() throws Exception 
	{
		try
		{
		testCar = Car.getCarFromString("C,r,Chevrolet,Aveo,Red", 1);
		lesserCar = Car.getCarFromString("C,r, ABC, Cab, Yellow", 2);
		equalCar = Car.getCarFromString("C,r,Chevrolet,Aveo,Red", 3);
		}
		catch (CarDataException err)
		{
			
		}
	}

	@Test
	public void testGetKindCar()
	{
			assertEquals(1, testCar.getKind());
	}
	
	@Test
	public void testGetDescription()
	{
		assertEquals("Chevrolet Aveo -- Red", testCar.getDescription());
	}
	
	@Test 
	public void testCarAvailability()
	{
		assertEquals(false, testCar.isAvailable());
	}
	
	@Test
	public void testCarKindError()
	{
		try
		{
			testCar = Car.getCarFromString("X, r, Honda, Odyssey,Blue", 1);
		}
		catch(CarDataException err)
		{
			assertEquals("Bad car kind on line: 1", err.getMessage());
		}
	}
	
	@Test 
	public void testCarAvailableError()
	{
		try
		{
			testCar = Car.getCarFromString("C, X, Honda, Odyssey,Blue", 1);
		}
		catch(CarDataException err)
		{
			assertEquals("Bad reserved status on line: 1", err.getMessage());
		}
	}
	
	@Test
	public void testCarDataError()
	{
		try
		{
			testCar = Car.getCarFromString("this is not valid text", 1);
		}
		catch(CarDataException err)
		{
			assertEquals("Bad data on line: 1", err.getMessage());
		}
	}
	
	@Test
	public void testCompareToLesser() 
	{
		assertEquals(-1, lesserCar.compareTo(testCar));
	}
	
	@Test
	public void testCompareToEqual()
	{
		assertEquals(0, equalCar.compareTo(testCar));
	}

}
