import java.awt.List;
import java.sql.Array;
import java.util.*;

class DynamicArray<E> {
    public E[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 3;

    /**
     * Constructor
     */
    DynamicArray() {
        array = (E[]) new Array[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Copy Constructor
     */
    DynamicArray(DynamicArray original) {
        E[] temp = (E[]) new Array[original.size];
        System.arraycopy(original.array, 0, temp, 0, original.size);
        this.array = temp;
        this.size = original.size;
    }

    /**
     * Adds an element. Extends the array if adding an element beyond the limits of the current array capacity.
     * Time Complexity: O(1)
     */
    public void add(E value) {
        if (size >= array.length) {
            resize(2 * array.length);
        }
        array[size] = (E) value;
        size++;
    }

    /**
     * Creates a resized array with extended capacity.
     * Time Complexity: O(n)
     */
    private void resize(int capacity) {
        E[] temp = (E[]) new Array[capacity];
        size = capacity < size ? capacity : size;
        if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    /**
     * Identifies data at a specified index.
     * Time Complexity O(1)
     */
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * Removes data at a specified index.
     * Time Complexity: O(n)
     */
    public void remove(int index) {
        E[] newArray = (E[]) new Array[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i != index) {
                newArray[k] = array[i];
                k++;
            }
        }
        this.array = newArray;
        size--;
    }

    /**
     * Returns the number of occupied elements
     * Time Complexity O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Determines if the array is empty.
     * Time Complexity O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Sets all elements to 0.
     * Time Complexity O(n)
     */
    public void clear() {
        Arrays.fill(array, 0);
        size = 0;
    }

    /**
     * Returns a combined string of the array data.
     * Time Complexity: O(n)
     */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder str = new StringBuilder();
        str.append('{');
        for (int i = 0; i < size; i++) {
            str.append(array[i]);
            if (i + 1 < size) {
                str.append(",");
            }
        }
        str.append('}');
        return str.toString();
    }

    /**
     * Identifies if two arrays are equal size and contain identical values.
     * Time Complexity: O(n)
     */
    public boolean equals(Object original) {
        if (this == original) {
            return false;
        }
        if (original == null) {
            return false;
        }
        if (getClass() != original.getClass()) {
            return false;
        }
        DynamicArray compared = (DynamicArray) original;
        if (size == compared.size) {
            for (int a = 0; a < size - 1; a++) {
                if (get(a) != compared.get(a)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}
