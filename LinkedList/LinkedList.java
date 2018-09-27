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
    
    public ListIterator listIterator()
    {
        return new LinkedListIterator(); 
    }
    
    class LinkedListIterator implements ListIterator
    {
        private Node position; 
        private Node previous; //need it to remove
        private boolean isAfterNext;
        
        public LinkedListIterator()
        {
            previous = null; 
            position = null;
            isAfterNext = false; 
        }
        public Object next() 
        {
           if (!hasNext())
           {
               throw new NoSuchElementException();
           }
           
           previous = position; //so items can be removed
           isAfterNext = true; 
           
           if (position == null) 
           {
               //its at the end, want to move it back to the beginning 
               position = first; //address/ref to Objects
            }
           else
           {
               position = position.next;
            }
           
           return position.data;
        }
        
        public boolean hasNext() 
        {
            if (position == null) 
            {
                return first != null;
            }
            
            return position.next != null; 
        
        }
        
        public void add(Object element)
        {
            if (position == null) 
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node(); 
                newNode.data = element; 
                newNode.next = position.next;
                position.next = newNode; 
                position = newNode; 
            }
            
            isAfterNext = false; 
        }
        
        public void remove() 
        {
            if(!isAfterNext) 
            {
                throw new IllegalStateException();
            }
            if (position == first) 
            {
                removeFirst(); 
            }
            
            else
            {
                previous.next = position.next;
            }
            position = previous; 
            isAfterNext = false; 
            }
        }
    }

