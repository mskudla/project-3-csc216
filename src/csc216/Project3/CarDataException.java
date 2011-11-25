package csc216.Project3;

public class CarDataException extends Exception
{

	public CarDataException(int lineNumber) 
	{
		System.out.println("Error at line: " + lineNumber + " invalid formating.");
	}

}
