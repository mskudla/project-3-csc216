package csc216.Project3;

public class CarLinkedList 
{
private Node head;  // Reference to the first element in the list  
private Node current;
private Node previous;
private String[] addCar;
private String[] stringByKind;
private Node k;
private Node p;
private Car[] addCar2;
private Car[] carByKind;
private int available;
private int reserved;
	
	// List elements are Nodes
	   private static class Node 
	   {
	      public Car car;
	      public Node link;
	      
	      // You must create a new Node with data and a reference to the next element.
	      public Node(Car car, Node link) 
	      {
	         this.car = car;
	         this.link = link;
	      }
	   }

	   /**
	    * Constructor -- creates an empty LinkedList.
	    */
	   public CarLinkedList() 
	   {
	      this.head = null;
	   }
	    
	   
	   /**
	    * Search for a particular object in the list.
	    * @param x the object to search for
	    * @return true if the list contains x, false if it does not
	    */
	   public boolean contains(Car x)
	   {
	      for (Node p = head; p != null; p = p.link) 
	      {
	         if (p.car.getDescription() == x.getDescription())
	            return true;
	      }
	      return false;
	   }

	   /**
	    * Print the list data to standard output.
	    *
	    */
	   public void print()
	   {
	      p = head;
	      while (p != null) 
	      {
	         System.out.println(p.car.getDescription() + " Available: " + p.car.getNumberAvailable() + " Reserved: " + p.car.getNumberReserved());
	         p = p.link;
	      }
	   }
	   
	   /**
	    * Inserts a new Car into the list in the appropriate position. 
	    * ASSUME the list is in ascending order.
	    * @param x string to be inserted into the list
	    */
	   public void insertAvailable(Car x){
	      current = this.head;  // First pointer to travel down the list
	      previous = null; // Follows the first pointer
	      
	      // Search for the insertion position
	      while (current != null && (current.car.compareTo(x) < 0)) 
	      {
	         previous = current;
	         current = current.link;
	      }

	      // Do the insertion now
	      if(current != null && current.car.compareTo(x) == 0)
	      {
	    		  current.car.returnToInventory();	    
	      }
	   
	      else
	      {
	    	  x.setNumberAvailable(1);
	    	  if (current == this.head) 
	    	  	{ // x belongs at the front of the list
	    		  this.head = new Node(x, this.head);

	    	  	}
	    	  else 
	    	  	{ // x belongs after the front item
	    		  previous.link = new Node(x, current);
	    	  	}     
	      }
	   }	   
	   /**Reserved list calls this function on itself to insert the car object in the proper spot.
	    * 
	    * @param x Car Object to be inserted into reserved list.
	    */
	   public void insertReserved(Car x){
		      current = this.head;  // First pointer to travel down the list
		      previous = null; // Follows the first pointer
		     
		    
		      // Search for the car object that already exists
		      while (current != null && (current != null && (current.car.compareTo(x) < 0))) {
		         previous = current;
		         current = current.link;
		      }

		      // increment the number reserved
		      if(current != null && current.car.compareTo(x) == 0)
		      {
		    	  current.car.reserve();   
		      }
		      
		      else
		      {
		    	  while (current != null)
		    	  {
		    		 previous = current;
			         current = current.link;
		    	  }
		    	  x.setNumberReserved(1);
		    	this.head = new Node(x, this.head);    
		      }
		      
		   }	   
	   /**Returns an array of car descriptions that are of kind kindToFind.
	    * 
	    * @param kindToFind int representation of the category of car we are interested in
	    * @return String array of car descriptions that are of kind kidnToFind.
	    */
	   public String[] getStringByKind(int kindToFind)
	   {
		   addCar = null;
		   stringByKind = new String[0];
		   k = this.head;
		      while (k != null) 
		      {
		    	  if(k.car.getCarKind() == kindToFind || kindToFind == 0)
		    	  {
		    		  addCar = new String[stringByKind.length + 1];
		    		  for(int i = 0; i < stringByKind.length; i ++)
		    			  addCar[i] = stringByKind[i];
		    		  addCar[stringByKind.length] = k.car.getDescription();
		    		  stringByKind = addCar;
		    	  }
		    	  k = k.link;
		      }
		      return stringByKind;
	   }
	   /**Returns an array of car objects parallel to getStringByKind.
	    * 
	    * @param kindToFind int representation of the kind of car to find.
	    * @return array of car objects parallel to getStringByKind
	    */
	   public Car[] getCarByKind(int kindToFind)
	   {
		   addCar2 = null;
		   carByKind = new Car[0];
		   k = this.head;
		      while (k != null) 
		      {
		    	  if(k.car.getCarKind() == kindToFind || kindToFind == 0)
		    	  {
		    		  addCar2 = new Car[carByKind.length + 1];
		    		  for(int i = 0; i < carByKind.length; i ++)
		    			  addCar2[i] = carByKind[i];
		    		  addCar2[carByKind.length] = k.car;
		    		  carByKind = addCar2;
		    	  }
		    	  k = k.link;
		      }
		      return carByKind;
	   }
	   
	   /**Available list calls this to clean itself up and take care of reserving a car.
	    * 
	    * @param reserved Car car that is going to be decremented in the available list.
	    */
	   public void cleanAvailable(Car reservedCar)
	   {
		   current = this.head;  // First pointer to travel down the list
		   previous = null; // Follows the first pointer
		   while (current != null)
		   {
			   if(current.car.compareTo(reservedCar) == 0)
				   current.car.removeFromInventory();			
			   
			   if(current.car.getNumberAvailable() == 0 && previous != null)
				   previous.link = current.link;
			   else if(current.car.getNumberAvailable() == 0 && previous == null)
			   {
				  this.head = current.link;
			   }
			   previous = current;
			   current = current.link;
		   }
	   }
	   /**
	    * Reserved list calls this 
	    * @param returnedCar
	    */
		public void cleanReserved(Car returnedCar)
		{
			 current = this.head;  // First pointer to travel down the list
			 previous = null; // Follows the first pointer   
			 while (current != null)
			   {
				 if(current.car.compareTo(returnedCar) == 0)
					 current.car.removeOneReserved();
				   if(current.car.getNumberReserved() == 0 && previous !=null)
					   previous.link = current.link;
				   else if(current.car.getNumberReserved() == 0 && previous == null)
					  this.head = current.link;
				   previous = current;
				   current = current.link;
			   }

	   }
		
		public int countAvailable()
		{
			available = 0;
			current = this.head;
			while(current != null)
			{
				available += current.car.getNumberAvailable();
				current = current.link;
			}
			return available;
		}
	   
		public int countReserved()
		{
			reserved = 0;
			current = this.head;
			while(current != null)
			{
				reserved += current.car.getNumberReserved();
				current = current.link;
			}
			return reserved;
		}
}
