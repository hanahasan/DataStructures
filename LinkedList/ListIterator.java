

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
    /**
     * adds an element before the iterator position
     * and moves the iterrator past the inserted element
     * @param element to add
     */
    void add(Object element);
    /**
     * removes the last traversed element. this method may 
     * only be called after a call to the next method
     */
    void remove();

}
