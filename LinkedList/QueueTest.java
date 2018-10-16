

/**
 * Write a description of class QueueTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueueTest
{
    public static void main(String[] arg) 
    {
        //LinkedListQueuestudent q = new LinkedListQueuestudent(); 
        CircularArrayQueue q = new CircularArrayQueue();
        q.add("Tom");
        q.add("Diana"); 
        q.add("Harry"); 
        //q.firstToLast();
        q.LastToFirst();
        
        System.out.print(q);
        
        
    }

}
