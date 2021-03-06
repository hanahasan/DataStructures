
import java.util.NoSuchElementException; 
import java.util.*; 
//import java.util.IllegalStateException; 

/**
 * Just keeps track of stuff- not the actual data 
 * @author Sarah Walz
 * @version (a version number or a date)
 */
public class LinkedList
{
    //Single linked list
    private Node first;
    //needs to access to all nods- so we need an inner class
    
    //can get at public data from node- but cannot acess this outside this class
    class Node
    {
        // Old School 
        //Put any object into and out of linkedlist
        //cast to type the object as we remove 
        public Object data;
        public Node next; 
    }
        
    /**
     * Default constructor for objects of class LinkedList
     */
    public LinkedList()
    {
        // initialise instance variables
        first= null; 
    }
    
    /**
     * Adds an element to the front of the LL
     * @param element, the element to add 
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node(); // is polymorphic- can be anything
        newNode.data= element; //the data will point to the object
        newNode.next= first; 
        first= newNode; 
    }
    
    /**
     * 
     */
    public void faultyAddFirst(Object element) 
    {
        Node newNode = new Node();
        first = newNode; 
        newNode.data = element; 
        newNode.next = first; 
    }
       
    /**
     * Retruns the first element of the LL
     * @return the first element as object
     */
    public Object getFirst()
    {
        if (first== null) {throw new NoSuchElementException();}
        return first.data; 
    }
    
    /**
     * Removes the first element in the LL
     * @return the removed element 
     */
    public Object removeFirst()
    {
        if (first== null) {throw new NoSuchElementException();}
        Object temp= first.data;
        first= first.next;
        return temp; 
    }
    
    /**
     * Reverses the List linkes
     * e16.1
     */
    public void reverse()
    {
       if (first== null) return; 
       
       Node previous = first; 
       Node current = first.next; 
       first.next = null; 
       while (current != null) 
       {
           Node next = current.next; 
           current.next = previous; 
           previous = current; 
           current = next; 
        }
       first = previous; 
    }
    
    /**
     * 
     */
    public int size() 
    {
        int count= 0; 
        //if (first== null) return count; 
        
        Node temp = first; 
        //count++; 
        
        while(temp!= null)
        {
            count++;
            temp=temp.next;
        }
        
        return count; 
    }
    
    public ListIterator listIterator()
    {
       return new LinkedListIterator();  
    }
    
    public String toString() 
    {
        ListIterator iter = this.listIterator(); 
        String returnString = ""; 
        while (iter.hasNext()) 
        {
            returnString += iter.next() + " ";
        }
        return returnString; 
    }
    
    public Object get(int n) 
    {
        return getNode(n).data;
        
    }
    
    public void set(int n, Object newElement)
    {
        getNode(n).data = newElement;
    }
    
    private Node getNode(int n) 
    {
        Node temp = new Node(); 
        temp = first;
        for (int i = 0; i < n ; i++)
        {
            temp = temp.next;
            
        }
        return temp;
    }
    
    public boolean contains(Object obj)
    {
        Node temp = new Node(); 
        temp = first;
        while (temp.next != null)
        {
            if (temp.data.equals(obj))
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
   
    
    class LinkedListIterator implements ListIterator //could implement iterator interface- but has extra methods we don't need
    {
        private Node position; 
        private Node previous;  //this is so we can remove 
        private boolean isAfterNext; 
        
        public LinkedListIterator()
        {
            position= null; 
            previous= null;
            isAfterNext= false;  
        }
        
        
        /**
        * Moves the iterator past the next element 
        * @return the traversed element 
        */
        public Object next()
        {
            if (!hasNext()) {throw new NoSuchElementException();}
            
            previous= position; //purly so that I can remove item
            isAfterNext= true; 
            
            if (position == null)//which means we would be at the very end or just started it
            {
                position= first; //just adress/references to objects
            }
            else
            {
                position= position.next;
            }
                        
            return position.data; 
        }
        
        /**
        *Tests if there is a next element
        * @return true if there is a next element 
        */
        public boolean hasNext()
        {
            if (position ==  null)
            {
                return first!= null; 
            }
            else
            {
                return position.next != null; 
            }
        }
        
        /**
         * Adds an element before the interator position
         * and moves the iterator past the inserted element
         * @param element the element to add
         */
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element); 
                position=first; 
            }
            else
            {
                Node newNode = new Node();
                
                newNode.data= element; 
                newNode.next= position.next;
                position.next= newNode;
                position= newNode; //moved forward one
            }
            
            isAfterNext= false; 
        }
        
        /**
         * Removes the last traversed element. this method may 
         * only be called after moving forward
         */
        public void remove()
        {
            if (!isAfterNext){throw new IllegalStateException();}
            
            if (position == first)
            {
                removeFirst(); 
            }
            else
            {
                previous.next= position.next; 
                
            }
            position= previous; 
            isAfterNext= false; 
        }
        
        
    }
        

}
