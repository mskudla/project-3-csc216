package csc216.Project3;

/**
 * Describes an item for rent. 
 * @author Jo Perry
 */
public interface RentalItem 
{
	
	/**
	 * Gets the description of the item.
	 * @return a string representation of the item.
	 */
	String getDescription();
	
	/**
	 * Is this item  available?
	 * @return true if the item is available, false otherwise.
	 */
	boolean isAvailable();	
	
	/**
	 * Place the item on reserve.
	 */
	void reserve();
	
	/**
	 * Make this item available.
	 */
	void returnToInventory();
	
	/**
	 * What is the "kind" of the item.
	 * @return the item kind.
	 */
	int getKind();
}