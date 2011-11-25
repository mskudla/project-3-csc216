package csc216.Project3;

public class CarLinkedList 
{
Node head;  // Reference to the first element in the list  
	
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
	      head = null;
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
	      Node p = head;
	      while (p != null) 
	      {
	         System.out.println(p.car.getDescription() + "Available: " + p.car.numberAvailable + " Reserved: " + p.car.numberReserved);
	         p = p.link;
	      }
	   }
	   
	   /**
	    * Inserts a new string into the list in the appropriate position. 
	    * ASSUME the list is in ascending order.
	    * @param x string to be inserted into the list
	    */
	   public void insertAvailable(Car x){
	      Node current = head;  // First pointer to travel down the list
	      Node previous = null; // Follows the first pointer
	      String insertCar = x.getDescription();
	      
	      // Search for the insertion position
	      while (current != null && (current.car.getDescription().compareTo(insertCar) < 0)) {
	         previous = current;
	         current = current.link;
	      }

	      // Do the insertion now
	      if(current != null && current.car.getDescription().compareTo(insertCar) == 0)
	      {
	    		  current.car.numberAvailable++;	    
	      }
	   
	      else
	      {
	    	  if (current == head) 
	    	  	{ // x belongs at the front of the list
	    		  head = new Node(x, head);
	    	  	}
	    	  else 
	    	  	{ // x belongs after the front item
	    		  previous.link = new Node(x, current);
	    	  	}     
	      }
	   }	   
	   
	   public void insertReserved(Car x){
		      Node current = head;  // First pointer to travel down the list
		      Node previous = null; // Follows the first pointer
		      String insertCar = x.getDescription();
		      
		      if(this.contains(x))
		      {
		    	  
		      // Search for the car object that already exists
		      while (current != null && (current.car.getDescription().compareTo(insertCar) != 0)) {
		         previous = current;
		         current = current.link;
		      }

		      // increment the number reserved
		      if(current != null && current.car.getDescription().compareTo(insertCar) == 0)
		      {
		    	  current.car.numberReserved++;
		    		  
		      }
		      }
		      else
		      {
		    		  head = new Node(x, head);    
		      }
		   }	   
	   
	   public String[] getStringByKind(int kindToFind)
	   {
		   String[] addCar = null;
		   String[] stringByKind = new String[0];
		   Node k = head;
		      while (k != null) 
		      {
		    	  if(k.car.carKind == kindToFind || kindToFind == 0)
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
	   
	   public Car[] getCarByKind(int kindToFind)
	   {
		   Car[] addCar = null;
		   Car[] carByKind = new Car[0];
		   Node k = head;
		      while (k != null) 
		      {
		    	  if(k.car.carKind == kindToFind || kindToFind == 0)
		    	  {
		    		  addCar = new Car[carByKind.length + 1];
		    		  for(int i = 0; i < carByKind.length; i ++)
		    			  addCar[i] = carByKind[i];
		    		  addCar[carByKind.length] = k.car;
		    		  carByKind = addCar;
		    	  }
		    	  k = k.link;
		      }
		      return carByKind;
	   }
	   
	   public void cleanAvailable()
	   {
//		   Node current = head;  // First pointer to travel down the list
//		   Node previous = null; // Follows the first pointer
//		   
//		   while (current != null)
//		   {
//			   if(current.car.numberAvailable == 0 && previous !=null)
//				   previous.link = current.link;
//			   else if(current.car.numberAvailable == 0 && previous == null)
//				  this.head = current.link;
//			   current = current.link;
		   }
		  
		public void cleanReserved()
		{
//			Node currentRes = this.head;
//			Node previousRes = null;
//			
//			while(currentRes != null)
//			{
//				if(currentRes.car.numberReserved == 0)
//					
//			}
			
			
//		}

	   }
	   
}
