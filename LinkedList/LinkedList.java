import java.util.NoSuchElementException;
/**
 * Write a description of class LinkedList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkedList
{
    private Node first; 
    
    class Node
    {
        //old skool 
        //any object into and out of a linked list 
        //cast to give the object a type whn object is removed
        public Object data; 
        public Node next; 
    }
    
    /**
     * Linked Constructor 
     */
    public LinkedList()
    {
        // initialise instance variables
        first = null;
    }

    /**
     * Adds element to the front of the Linked List
     * @param element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node(); 
        newNode.data = element; //points to object 
        newNode.next = first; 
        first = newNode; 
    }
    
    /**
     * returns the first element in the Linked List 
     * @return first element in linked list 
     */
    public Object getFirst()
    {
        if (first == null) 
        {
            throw new NoSuchElementException();
        }
        return first.data; 
    }
    
    /**
     * Removes te first element in the linked list
     * @return the removed element
     */
    public Object removeFirst()
    {
        if (first == null) 
        {
            throw new NoSuchElementException();
        }
        //links have to be maintained 
        Object element = first.data;
        first = first.next;
        return element;
    }
}
