

/**
 * Write a description of class stackDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stackDemo
{
    
    public static void main (String [] args) 
    {
        LinkedListStack newStack = new LinkedListStack(); 
        
        newStack.push("Hello"); 
        newStack.push("Remove Me"); 
        newStack.pop();
        newStack.pop();
        System.out.println(newStack.isEmpty());
        
    }

}
