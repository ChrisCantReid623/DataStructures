class ListQueue <E> implements QueueInterface{
    private LinkedList<E> queue;

    /** Constructor */
    ListQueue() {
        queue = new LinkedList<>();
    }

    /** Copy Constructor */
    ListQueue(ListQueue<E> original) {
        queue = new LinkedList<>(original.queue);
    }

    /** Pushes a new value at the back of the queue.
     * Time Complexity: O(1) */
    public void enqueue(Object value) {
        queue.addLast((E) value);
    }

    /** Removes the value at the front of the queue.
     * Time Complexity: O(1) */
    public E dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.removeFirst();
    }

    /** Identifies the value at the front of the queue.
     * Time Complexity: O(1) */
    public E peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    /** Identifies if the queue is empty.
     * Time Complexity: O(1) */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /** Returns the number of nodes.
     * Time Complexity: O(1) */
    public int size() {
        return queue.size();
    }

    /** Removes all data.
     * Time Complexity: O(1) */
    public void clear() {
        queue.clear();
    }

    /** Returns a combined strong of the queue contents.
     * Time Complexity: O(n) */
    public String toString() {
        return queue.toString();
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

        ListQueue compared = (ListQueue)original;
        return queue.equals(compared.queue);
    }
}
