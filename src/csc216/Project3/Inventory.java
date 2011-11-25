package csc216.Project3;

/**
 * Behaviors provided by a collection of items that can be available for
 *   rent or reserved (not available). The items can be grouped by
 *   "kind."
 * @author Jo Perry
 */
public interface Inventory 
{
	/** 
	 * Find all items of this kind in the pool of available items
	 *   and return them as an array of Strings. Each element in 
	 *   the array corresponds to an item in the inventory.
	 * @param kind filters the items to be considered.
	 * @return String representing all items of the 
	 *   given kind. 
	 */
	String[] availableByKind(int kind);
	
	/**
	 * Find all items in the inventory that are reserved and 
	 *   return them as an array of Strings. Each element in the array
	 *   corresponds to a reserved item.
	 * @return String representing all reserved items. 
	 */
	String[] reserved();
	
	/**
	 * Reserve an item from the pool of available items, filtered
	 *   by kind. The item reserved is determined by its position
	 *   in the string returned by availableByKind(). 
	 * @param position position (index) of item to be reserved.
	 * @param kind determines which items are considered.
	 */
	void reserveItem(int position, int kind);
	
	/**
	 * A reserved item to the pool of available items, where the item
	 *   is determined by its position in the string returned by 
	 *   reserved().
	 * @param position position of the item to be returned.
	 */
	void returnItem(int position);
	
	/**
	 * Total number of individual available items.
	 * @return the number of available items.
	 */
	int totalAvailable();
	
	/**
	 * Total number of individual reserved items.
	 * @return the number of reserved items.
	 */
	int totalReserved();
}