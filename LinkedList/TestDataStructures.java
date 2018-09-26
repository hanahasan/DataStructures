

/**
 * Write a description of class TestDataStructures here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestDataStructures
{
    public static void main (String[] args)
    {
        LinkedList testLL = new LinkedList();
        String word = "Hello";
        testLL.addFirst(word);
        testLL.addFirst(new String("There"));
        
        //OLD school 
        //word2 = s.getFirst();// this returns an Object, word2 aint one
        String word2 = (String) testLL.getFirst();
        System.out.print(word2);
    }
}
