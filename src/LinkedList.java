class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private class Node<E> {
        private E data;
        private LinkedList<E>.Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Default Constructor
     */
    LinkedList() {
    }

    /**
     * Copy Constructor
     */
    LinkedList(LinkedList<E> original) {
        head = new Node<>(original.head.data);
        size = original.size;
        Node<E> copyNext = original.head.next;
        Node<E> current = head;

        while (copyNext != null) {
            Node<E> newCopy = new Node<E>(copyNext.data);
            newCopy.next = copyNext.next;
            current.next = newCopy;
            current = newCopy;
            copyNext = newCopy.next;
        }
        tail = current;
    }

    /**
     * Adds a new node.
     * Time Complexity: O(n)
     */
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        size++;

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Returns the data stored in the last node.
     * Time Complexity: O(1)
     */
    public E getLast() {
        return tail.data;
    }

    /**
     * Returns the data stored in a node at a specified index.
     * Time Complexity: O(n)
     */
    public E get(int index) {
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * Removes the last node.
     * Time Complexity: O(n)
     */
    public void removeLast() {
        Node<E> curr = head;

        if (head != null) {
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
        size--;
    }

    /**
     * Removes the first node.
     * Time Complexity: O(1)
     */
    public E removeFirst() {
        E removed = head.data;
        head = head.next;
        size--;
        return removed;
    }

    /**
     * Returns a combined string of the list data.
     * Time Complexity O(n)
     */
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder str = new StringBuilder();
        str.append('{');
        Node currNode = head;
        while (currNode != null) {
            str.append(currNode.data);
            if (currNode.next != null) {
                str.append(",");
            }
            currNode = currNode.next;
        }
        str.append('}');
        return str.toString();
    }

    /**
     * Returns the number of nodes.
     * Time Complexity O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Removes all nodes.
     * Time Complexity O(1)
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Identifies if the list is empty.
     * Time Complexity O(1)
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Identifies if two lists are equal size and contain identical values.
     * Time Complexity O(n)
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
        LinkedList<E> compared = (LinkedList<E>) original;
        if (size == compared.size) {
            Node head1 = head;
            Node head2 = compared.head;
            while (head1 != null && head2 != null) {
                if (head.data != compared.head.data) {
                    return false;
                }
                head1 = head1.next;
                head2 = head2.next;

            }
            return true;
        }
        return false;
    }

}
