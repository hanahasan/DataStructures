/**
   Add a method firstToLast to this implementation of a queue.
   The method moves the element at the head of the queue to
   the tail of the queue. The element that was second in line
   will now be at the head.
*/
public class LinkedListQueuestudent
{
   private Node head;
   private Node tail;

   /**
      Constructs an empty queue.
   */
   public LinkedListQueuestudent()
   {
      head = null;
      tail = null;
   }

   /**
      Moves the head of the queue to the tail.
   */
   public void firstToLast()
   {
       //add(remove());
       tail.next = head; 
       tail = head; 
       head = head.next; 
       tail.next = null;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
      return head == null;
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
       if (tail == null) 
       {
           Node newNode = new Node(); 
           newNode.data = newElement;
           newNode.next = null;  
           tail = newNode; 
           head = newNode; 
        }
       else 
       {
           Node newNode = new Node(); 
           newNode.data = newElement;
           newNode.next = null;
           tail.next = newNode; 
           tail = newNode;
        }
        }
   

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
       if (empty())
       {
           return null; 
        }
       Object element = head.data; 
       head = head.next; //moves the head towards the tail 
       if (empty())
       {
           tail = null; 
        }
       return element;
    }
    
   public void LastToFirst()
   {
       Node newNode = tail; 
       newNode.next = head; 
       
       head = newNode; 
       
       Node temp = head; 
       while (temp.next != tail) 
       {
           temp = temp.next;
        }
        
        tail = temp; 
        tail.next = null; 
    }

   class Node
   {
      public Object data;
      public Node next;
   }
}
