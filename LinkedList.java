/*
 * Student information for assignment: 
 * On my honor, Dominic Paruolo, this programming assignment is my own work 
 * and I have not provided this code to any other student. 
 * UTEID: dmp3588
 * email address: dominicparuolo78@gmail.com 
 * Number of slip days I am using: 0
 */

import java.util.Iterator;

public class LinkedList<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements. 
    // No ArrayLists or Java LinkedLists.

	private int size;
	private final DoubleListNode<E> HEADER;
	
    // CS314 students, add constructors here:
	/**
	 * Big O of this method is O(1)
	 * Creates a new LinkedList object by utilizing a header
	 * node that is stored in an instance variable.
	 */
	public LinkedList() {
		//creates new linked list using header node
		HEADER = new DoubleListNode<>();
		HEADER.next = HEADER;
		HEADER.prev = HEADER;
	}
    // CS314 students, add methods here:
	
    /**
     * Big O of this method is O(1)
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list,
     * item != null
     */
    public void add(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: add."
    				+ " Parameter must not be null.");
    	}
    	//adds new node to end of list and updates surrounding nodes
    	DoubleListNode<E> newLastNode = new DoubleListNode<>(HEADER.prev, item, HEADER);
    	HEADER.prev.next = newLastNode;
    	HEADER.prev = newLastNode;
    	size++;
    }
    
    /**
     * Big O of this method is O(N)
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
    */
    public void insert(int pos, E item) {
    	if (pos < 0 || pos > size || item == null) {
    		throw new IllegalArgumentException("Violation of precondition: insert."
    				+ " Parameter pos must not be less than 0 or greater than size() and"
    				+ " parameter item must not be null.");
    	}
    	//finds the node currently in the spot to be inserted
        DoubleListNode<E> currentNode = getNode(pos);
        //inserts new node to pos and updates surrounding nodes
    	DoubleListNode<E> newNode = new DoubleListNode<>(currentNode.prev, item, currentNode);
    	currentNode.prev.next = newNode;
    	currentNode.prev = newNode;
    	size++;
    }
	
    /**
     * Big O of this method is O(N)
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * @return the old data at the specified position
     */
    public E set(int pos, E item) {
    	if (pos < 0 || pos >= size || item == null) {
    		throw new IllegalArgumentException("Violation of precondition: set."
    				+ " Parameter pos must not be less than 0 or greater than or equal to size()"
    				+ " and parameter item must not be null.");
    	}
    	//finds node to be changed
    	DoubleListNode<E> currentNode = getNode(pos);
    	//updates nodes data and stores old data
    	E oldData = currentNode.data;
    	currentNode.data = item;
    	return oldData;
    }
    
    /**
     * Big O of this method is O(N)
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
    public E get(int pos) {
    	if (pos < 0 || pos >= size) {
    		throw new IllegalArgumentException("Violation of precondition: get."
    				+ " Parameter pos must not be less than 0 or greater than or equal"
    				+ " to size()");
    	}
    	//finds data from specified node
    	return getNode(pos).data;
    }
    
    /**
     * Big O of this method is O(N)
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
    public E remove(int pos) {
    	if (pos < 0 || pos >= size) {
    		throw new IllegalArgumentException("Violation of precondition: remove."
    				+ " Parameter pos must not be less than 0 or greater than or equal"
    				+ " to size()");
    	}
    	//finds node at pos
    	DoubleListNode<E> removedNode = getNode(pos);
    	//store data of removed node
    	E removedData = removedNode.data;
    	//updates surrounding nodes to skip over removed node
    	removedNode.prev.next = removedNode.next;
    	removedNode.next.prev = removedNode.prev;
    	size--;
    	return removedData;
    }
    
    /**
     * Big O of this method is O(N)
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     */
    public boolean remove(E obj) {
    	if (obj == null) {
    		throw new IllegalArgumentException("Violation of precondition: remove."
    				+ " Parameter must not be null.");
    	}
    	DoubleListNode<E> removedNode = HEADER.next;
        //searches nodes for first occurrence of obj	
    	while (!removedNode.equals(HEADER)) {
    		//removes first instance of obj
    		if (removedNode.data.equals(obj)) {
    	    	removedNode.prev.next = removedNode.next;
    	    	removedNode.next.prev = removedNode.prev;
    	    	size--;
    			return true;
    		}
    		removedNode = removedNode.next;
    	}
    	return false;
    }
    
    /**
     * Big O of this method is O(N)
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element
     * of the sublist.
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     */
    public IList<E> getSubList(int start, int stop) {
    	if (start < 0 || start > size || start > stop || stop > size) {
    		throw new IllegalArgumentException("Violation of precondition: getSubList."
    				+ " Parameter start must be greater than or equal to 0 and less than"
    				+ " or equal to size. Parameter stop must be greater than or equal to"
    				+ " start and less than or equal to size.");
    	}
    	IList<E> subList = new LinkedList<>();
    	//finds the first node to be added to sublist
    	DoubleListNode<E> tempNode = getNode(start);
    	//adds nodes from start to stop indexes to sublist
    	for (int i = start; i < stop; i++) {
    		subList.add(tempNode.data);
    		tempNode = tempNode.next;
    	}
    	return subList;
    }
    
    /**
     * Big O of this method is O(1)
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     */
    public int size() {
    	//num of nodes
    	return size;
    }
    
    /**
     * Big O of this method is O(N)
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     */
    public int indexOf(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: indexOf."
    				+ " Parameter must not be null.");
    	}
    	//finds index of item
    	return indexOf(item, 0);
    }

    /**
     * Big O of this method is O(N)
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     */
    public int indexOf(E item, int pos) {
    	if (pos < 0 || pos >= size || item == null) {
    		throw new IllegalArgumentException("Violation of precondition: indexOf."
    				+ " Parameter pos must be greater than or equal to 0 and"
    				+ " less than size. Parameter item must not be null.");
    	}
    	//finds node at pos
    	DoubleListNode<E> tempNode = getNode(pos);
    	//finds index of item from pos index to end of list if present
    	for (int i = pos; i < size; i++) {
    		if (tempNode.data.equals(item)) {
    			return i;
    		}
    		tempNode = tempNode.next;
    	}
    	return -1;
    }

    /**
     * Big O of this method is O(1)
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void makeEmpty() {
    	//resets instance variables to initial values
    	HEADER.next = HEADER;
    	HEADER.prev = HEADER;
    	size = 0;
    }
    
    /**
     * Big O of this method is O(N)
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop stop - 1 is the position at the end
     * of the range of elements to be removed
     */
    public void removeRange(int start, int stop) {
    	if (start < 0 || start > size || start > stop || stop > size) {
    		throw new IllegalArgumentException("Violation of precondition: removeRange."
    				+ " Parameter start must be greater than or equal to 0 and less than"
    				+ " or equal to size. Parameter stop must be greater than or equal to"
    				+ " start and less than or equal to size.");
    	}
    	//finds first node to remove
    	DoubleListNode<E> startNode = getNode(start);
    	//finds node after last node to remove
    	DoubleListNode<E> stopNode = getNode(stop);
    	//removes all nodes between start and stop nodes
        startNode.prev.next = stopNode;
        stopNode.prev = startNode.prev;
    	size -= stop - start;
    }
    
    /**
     * Big O of this method is O(N)
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * are in order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     * @return a String representation of this IList
     */
    public String toString() {
    	DoubleListNode<E> temp = HEADER.next;
    	StringBuilder sb = new StringBuilder("[");
    	//adds all node data to stringbuilder
    	while (!temp.equals(HEADER)) {
    		sb.append(temp.data);
    		//only adds ", " if not last element
    		if (!temp.next.equals(HEADER)) {
    			sb.append(", ");
    		}
    		temp = temp.next;
    	}
    	//returns string version of stringbuilder
    	return sb.append("]").toString();
    }

    /**
     * Big O of this method is O(N)
     * Determine if this IList is equal to other. Two
     * ILists are equal if they contain the same elements
     * in the same order.
     * @return true if this IList is equal to other, false otherwise
     */
    public boolean equals(Object other) {
    	//finds if other is an instance of IList
    	if (other instanceof IList<?>) {
    		Iterator<E> thisList = this.iterator();
    		//casts other to IList and makes new IList and Iterator
    		IList<?> otherIList = (IList<?>) other;
    		Iterator<?> otherList = ((IList<?>) other).iterator();
    		//ensures the lists are the same size
    	    if (otherIList.size() != size) {
    		    return false;
    	    }
    	    //finds if any values from each list are different
    	    for (int i = 0; i < size; i++) {
    		    if (!otherList.next().equals(thisList.next())) {
    			    return false;
    		    }
    	    }	
    	}
    	return true;
    }
    
    /**
     * Big O of this method is O(N)
     * Helper method for LinkedList class that returns the node at the position specified.
     * @param pos, the position of the node in the list.
     * @return the node at the given position.
     */
    private DoubleListNode<E> getNode(int pos) {
    	DoubleListNode<E> tempNode;
    	//checks if to start at end of list or beginning
    	if (pos < size/2) {
    		tempNode = HEADER;
    		//finds node at pos
    	    for (int i = -1; i < pos; i++) {
    		    tempNode = tempNode.next;
    	    }
    	} else {
    		tempNode = HEADER;
    		//finds node at pos
    		for (int i = size; i > pos; i--) {
    			tempNode = tempNode.prev;
    		}
    	}
    	return tempNode;
    }
	
    /**
    * Big O of this method is O(1)
    * return an Iterator for this list.
    * <br>pre: none
    * <br>post: return an Iterator object for this List
    */
    public Iterator<E> iterator() {
    	return new LLIterator();
    }
    
    private class LLIterator implements Iterator<E>{

    	private DoubleListNode<E> nextNode;
    	private boolean canRemove;
    	
    	/**
    	 * Big O of this method is O(1)
    	 * Creates new LLIterator object
    	 */
    	private LLIterator() {
    		nextNode = HEADER.next;
    	}
    	
		/**
		 * Big O of this method is O(1)
		 * Finds if there is another object after the current value to traverse to.
		 */
		public boolean hasNext() {
	        return !nextNode.equals(HEADER);
		}

		/**
		 * Big O of this method is O(1)
		 * Traverses to the next object in a list.
		 * Returns the data of the next object.
		 */
		public E next() {
			if (!hasNext()) {
				throw new IllegalArgumentException("Violation of precondition: next."
						+ " hasNext() must be true.");
			}
			//stores data of current next node
			E newData = nextNode.data;
			//increments nextNode to the next node
			nextNode = nextNode.next;
			//allows remove method to be called
			canRemove = true;
			return newData;
		}
		
		/**
		 * Big O of this method is O(1)
		 * Removes the current node from the list.
		 */
		public void remove() {
			if (!canRemove) {
				throw new IllegalArgumentException("Violation of precondition: remove."
						+ " canRemove must be true.");
			}
			//removes the current node
			nextNode.prev.prev.next = nextNode;
			nextNode.prev = nextNode.prev.prev;
			//disallows remove from being called again
			canRemove = false;
			size--;
		}
    	
    }
    
    /**
     * Big O of this method is O(1)
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     * 
     * @param item the data to add to the front of this list
     */
    public void addFirst(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: addFirst."
    				+ " Parameter must not be null.");
    	}
    	DoubleListNode<E> newNode = new DoubleListNode<>(HEADER, item, HEADER.next);
    	//inserts new node in first spot
    	HEADER.next.prev = newNode;
    	HEADER.next = newNode;
    	size++;
    }

    /**
     * Big O of this method is O(1)
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     * 
     * @param item the data to add to the end of this list
     */
    public void addLast(E item) {
    	if (item == null) {
    		throw new IllegalArgumentException("Violation of precondition: addLast."
    				+ " Parameter must not be null.");
    	}
    	//adds new node in last spot
    	add(item);
    }

    /**
     * Big O of this method is O(1)
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * 
     * @return the old first element of this list
     */
    public E removeFirst() {
    	if (size <= 0) {
    		throw new IllegalArgumentException("Violation of precondition: removeFirst."
    				+ " The list size must be greater than 0.");
    	}
    	//stores the old data from first node
    	E oldData = HEADER.next.data;
    	//removes first node
    	HEADER.next.next.prev = HEADER;
    	HEADER.next = HEADER.next.next;
    	size--;
        return oldData;
    }

    /**
     * Big O of this method is O(1)
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * 
     * @return the old last element of this list
     */
    public E removeLast() {
    	if (size <= 0) {
    		throw new IllegalArgumentException("Violation of precondition: removeFirst."
    				+ " The list size must be greater than 0.");
    	}
    	//stores the old data from last node
    	E oldData = HEADER.prev.data;
    	//removes last node
    	HEADER.prev.prev.next = HEADER;
    	HEADER.prev = HEADER.prev.prev;
    	size--;
        return oldData;        
    }

    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version 9/25/2023
     */

    private static class DoubleListNode<E> {

        // instance variables

        // The data stored in this node.
        private E data;

        // The link to the next node (presumably in a list).
        private DoubleListNode<E> next;

        // The link to the previous node (presumably in a list).
        private DoubleListNode<E> prev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: getData() = null, getNext() = null, getPrev() = null
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: getData() = data, getNext() = next, getPrev() = prev
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data,
                DoubleListNode<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        /* Note, the following methods are not necessary.
         * They are provided as a convenience. As this class is a private
         * nested class the only client is the LinkedList class itself and
         * the implementation of Iterator. We leave it up to the student
         * whether to access and change the private instance variables of a
         * node directly or via these methods.
         */
        /**
         * return the data in this node.
         * <br>pre: none
         * @return the data this DoubleListNode holds
         */
        public E getData() {
            return data;
        }

        /**
         * return the DoubleListNode this ListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the next one in a list)
         */
        public DoubleListNode<E> getNext() {
            return next;
        }

        /**
         * return the DoubleListNode this DoubleListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the previous one in a list)
         */
        public DoubleListNode<E> getPrev() {
            return prev;
        }

        /**
         * set the data in this node.
         * The old data is over written.
         * <br>pre: none
         * <br>post: getData() == data
         * @param data the new data for this DoubleListNode to hold
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * set the next node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getNext() = next
         * @param next the next node this DoubleListNode should refer to
         */
        public void setNext(DoubleListNode<E> next) {
            this.next = next;
        }

        /**
         * set the previous node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getPrev() = next
         * @param prev the previous node this DoubleListNode should refer to
         */
        public void setPrev(DoubleListNode<E> prev) {
            this.prev = prev;
        }
    }

}