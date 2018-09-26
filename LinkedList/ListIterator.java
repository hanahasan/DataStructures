

/**
 * Write a description of interface ListIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ListIterator
{
    /**
     * Moves Iterator past the next element
     * @return    the traversed element 
     */
    Object next();
    /**
     * Tests if there is an element after the iterator position
     * @return true if there is an element after the iterator position
     */
    boolean hasNext();

}
