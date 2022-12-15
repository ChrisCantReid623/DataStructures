class ArrayStack <E> implements StackInterface {
    private DynamicArray stack;

    /** Constructor */
    ArrayStack() {
        stack = new DynamicArray();
    }

    /** Copy Constructor */
    ArrayStack(ArrayStack original) {
        this.stack = new DynamicArray(original.stack);
    }

    /**Adds a value to the top.
     * Time Complexity: O(1) amortized */
    public void push(Object value) {
        stack.add(value);
    }

    /** Removes the top value.
     * Time Complexity: O(1) amortized */
    public E pop() {
        if (stack.isEmpty()) {
            return null;
        }
        E removed = (E) stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return removed;
    }

    /** Identifies the value at the top.
     * Time Complexity: O(1) */
    public E peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return (E) stack.get(stack.size() - 1);
    }

    /** Identifies if the stack is empty.
     * Time Complexity: O(1) */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /** Returns the number of occupied slots.
     * Time Complexity: O(1) */
    public int size() {
        return stack.size();
    }

    /** Removes all values.
     * Time Complexity: O(1) */
    public void clear() {
        stack.clear();
    }

    /** Returns a combined string of the stack contents.
     * Time Complexity: O(n) */
    public String toString() {
        return stack.toString();
    }

    /** Identifies if two arrays are equal size and contain identical values.
     * Time Complexity: O(n) */
    public boolean equals(Object original) {
        if (this == original) {
            return true;
        }
        if (original == null) {
            return false;
        }
        if (getClass() != original.getClass()) {
            return false;
        }

        ArrayStack compared = (ArrayStack)original;
        return stack.equals(compared.stack);
    }
}