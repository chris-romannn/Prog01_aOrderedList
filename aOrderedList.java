import java.util.Arrays;
/**
 * aOrderedList class. is a sorted list, that remains sorted whether data is added or removed from it
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Christopher Roman
 * @since 3/17/24
 */
public class aOrderedList <T>{
    // Private Members
    final int SIZEINCREMENTS = 20; // size of increments for increasing ordered list
    private T[] oList; // the ordered list
    private int listSize; // the size of the ordered list
    private int numObjects; // the number of objects in the ordered list
    private int curr;// index of current element accessed via iterator methods

    // Constructor
    public aOrderedList() {
        numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = (T[])new Comparable[listSize];
        curr = -1;
    }

    // Public Methods

    /**
     * Method to add a new object to the ordered list.
     *
     *
     * @param newObject the new object to be added to the list
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public void add(T newObject) {
        if (numObjects == listSize) {
            listSize += SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);
        }
        oList[numObjects] = newObject;
        numObjects++;
        Arrays.sort(oList, 0, numObjects);
    }

    /**
     * Method to get the element at the specified index.
     *
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public T get(int index) {
        if (index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numObjects);
        }
        return oList[index];
    }

    /**
     * Method to reset the iterator parameters.
     *
     * CSC 1351 Programming Project No 1
     * Section section 2
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public void reset() {
        curr = 0;
    }

    /**
     * Method to get the next element in the iteration.
     *
     * CSC 1351 Programming Project No 1
     * Section section 2
     *
     * @return the next element in the iteration
     *
     * @author Christopher Roman
     * @ since 3/17/24
     */
    public T next() {
        if(hasNext()) {
            curr++;
            return oList[curr];
        }
        return null;

    }

    /**
     * Method to check if the iteration has more elements to iterate through.
     *
     * @return true if the iteration has more elements, false otherwise
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public boolean hasNext() {
        return (curr+1) < numObjects;
    }
    /**
     * Method to remove the car at the specified index.
     *
     * @param index the index of the car to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public void remove(int index) {
        if(index < 0 || index >= numObjects) {
            throw new IndexOutOfBoundsException();
        }

        for(int i = index; i < numObjects - 1; i++) {
            oList[i] = oList[i + 1];
        }
        oList[numObjects - 1] = null;
        numObjects--;

        if(numObjects == listSize) {
            listSize -= SIZEINCREMENTS;
            oList = Arrays.copyOf(oList, listSize);
        }
    }

    public void remove() {
        if(curr >= 0) {
            remove(curr);
            curr--;
        }
    }

    /**
     * Method to get the number of elements in the list.
     *
     * CSC 1351 Programming Project No 1
     * Section section 2
     *
     * @return the number of elements in the list
     *
     * @author Christopher Roman
     * @ since 3/17/24
     */
    public int size() {
        return numObjects;
    }




    /**
     * Method to generate a string representation of the ordered list.
     *
     * CSC 1351 Programming Project No 1
     * Section section 2
     *
     * @return a string representation of the ordered list
     *
     * @author Christopher Roman
     * @ since 3/17/24
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < numObjects; i++) {
            result.append(oList[i].toString());
            if (i < numObjects - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}