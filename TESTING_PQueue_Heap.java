public class TESTING_PQueue_Heap {
    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {

        PriorityQueue p = new PriorityQueue();

        System.out.println("Check the size:");
        System.out.println(p.size() == 0);

        System.out.println();

        Patient A = new Patient("A", 7);
        Patient B = new Patient("B", 68);
        Patient C = new Patient("C", 25);
        Patient D = new Patient("D", 4);
        Patient E = new Patient("E", 3);
        Patient F = new Patient("F", 81);
        Patient G = new Patient("G", 53);
        Patient H = new Patient("H", 90);
        Patient I = new Patient("J", 18);
        Patient J = new Patient("K", 39);
        Patient K = new Patient("L", 47);
        Patient L = new Patient("M", 75);

        p.enqueue("A", 7);
        p.enqueue("B", 68);
        p.enqueue("C", 25);
        p.enqueue("D", 4);
        p.enqueue("E", 3);
        p.enqueue("F", 81);
        p.enqueue("G", 53);

        System.out.println("Check the print:");
        System.out.println("{E (3), D (4), C (25), B (68), A (7), F (81), G (53)}".equals(p.toString()));

        System.out.println();

        System.out.println("Check if empty: and size");
        System.out.println(p.size() == 7);
        System.out.println(p.isEmpty() == false);

        System.out.println();

        System.out.println("Check the peeks:");
        System.out.println(p.peek().equals("E"));
        System.out.println(p.peekPriority() == 3);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("D"));
        System.out.println(p.peekPriority() == 4);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("A"));
        System.out.println(p.peekPriority() == 7);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("C"));
        System.out.println(p.peekPriority() == 25);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("G"));
        System.out.println(p.peekPriority() == 53);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("B"));
        System.out.println(p.peekPriority() == 68);
        System.out.println();
        p.dequeue();
        System.out.println(p.peek().equals("F"));
        System.out.println(p.peekPriority() == 81);
        p.dequeue();

        System.out.println();

        System.out.println("Check if empty:");
        System.out.println(p.isEmpty() == true);
        System.out.println(p.toString().equals("{}"));

        System.out.println();

        p.enqueue(A);
        p.enqueue(B);
        p.enqueue(C);
        p.enqueue(D);
        p.enqueue(E);
        p.enqueue(F);
        p.enqueue(G);
        p.enqueue(H);
        p.enqueue(I);
        p.enqueue(J);
        p.enqueue(K);
        p.enqueue(L);

        System.out.println("Check the print:");
        System.out.println(p.toString().equals("{E (3), D (4), C (25), J (18), A (7), M (75), G (53), H (90), B (68), K (39), L (47), F (81)}"));

        System.out.println();

        System.out.println("Check if empty and size:");
        System.out.println(p.size() == 12);
        System.out.println(p.isEmpty() == false);
        System.out.println(p.toString().equals("{}") == false);

        System.out.println();

        p.changePriority("E", 100);
        System.out.println("Check the print:");
        System.out.println(p.toString().equals("{D (4), A (7), C (25), J (18), K (39), M (75), G (53), H (90), B (68), E (100), L (47), F (81)}"));

        System.out.println();

        System.out.println();

        p.changePriority("E", 3);
        System.out.println(p.toString());
        System.out.println("Check the print:");
        System.out.println(p.toString().equals("{E (3), D (4), C (25), J (18), A (7), M (75), G (53), H (90), B (68), K (39), L (47), F (81)}"));

        System.out.println();

        System.out.println("Check if empty and size:");
        System.out.println(p.size() == 12);
        System.out.println(p.isEmpty() == false);
        System.out.println(p.toString().equals("{}") == false);



    }
    public static void test2() {
        var object = new PriorityQueue();

        object.enqueue("Chris", 9);
        System.out.println(object.peekPriority());
        System.out.println(object.peek());
        System.out.println(object.dequeue());
        System.out.println(object);

        for (int i = 1; i <= 8; i++ ) {
            object.enqueue("Christopher " + i, i);
        }
        System.out.println();
        System.out.println(object);

        KthLargest(object, 5);
        System.out.println();

        System.out.print("Top Patient: " + object.peek());
        System.out.println(": Patient Priority: " + object.peekPriority());
        object.changePriority("Christopher 1", 11);
        System.out.println();
        System.out.println(object);
        System.out.println();

        while (!object.isEmpty()) {
            System.out.print("Top Patient: " + object.peek());
            System.out.println(": Patient Priority: " + object.peekPriority());
            System.out.println("Dequeued: " + object.dequeue());
            System.out.println(object);
            System.out.println();
        }

        object.enqueue("Debra", 1);
        object.enqueue("Jayden", 4);
        object.enqueue("Christopher", 1);
        object.enqueue("Ricardo", 2);
        object.enqueue("Whitney", 3);
        object.enqueue("Marissa", 3);
        System.out.println(object);

        System.out.println(object.parent(1));
        System.out.println(object.parent(2));
        System.out.println(object.parent(3));
        System.out.println(object.parent(4));
        System.out.println(object.parent(5));

        object.enqueue("A", 5);
        object.enqueue("B", 4);
        object.enqueue("C", 3);
        object.enqueue("D", 2);
        object.enqueue("E", 1);
        System.out.println();
        System.out.println(object);
        object.changePriority("E", 3);
        System.out.println();
        System.out.println(object);

        while (!object.isEmpty()) {
            System.out.print("Top Patient: " + object.peek());
            System.out.println(": Patient Priority: " + object.peekPriority());
            System.out.println("Dequeued: " + object.dequeue());
            System.out.println(object);
            System.out.println();
        }
    }
    public static void KthLargest(PriorityQueue queue, int k) {
        if (k < queue.size()) {
            while (queue.size() > k) {
                queue.dequeue();
            }
            System.out.println(queue.peek());
        }
    }
}

class Patient {
    public String name;
    public int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return name + " (" + priority + ")";
    }
}
class PriorityQueue {
    private Patient[] heap;
    private int size;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Constructor
     */
    public PriorityQueue() {
        heap = new Patient[DEFAULT_SIZE];
        heap[0] = null;
        size = 0;
    }

    /**
     * Extends the heap when capacity is reached.
     */
    private void resize(int capacity) {
        var temp = new Patient[capacity];
        size = capacity < size ? capacity : size;
        if (size >= 0) System.arraycopy(heap, 0, temp, 0, size);
        heap = temp;
    }

    /**
     * Method to properly re-slot an element towards the 'front'.
     */
    private void bubbleUp(int i) {
        if (i > 1) {
            if (compare(heap[i], heap[parent(i)])) {
                var parent = heap[parent(i)];
                heap[parent(i)] = heap[i];
                heap[i] = parent;
                bubbleUp(parent(i));
            }
        }
    }

    /**
     * Method to properly re-slot an element towards the 'rear'.
     */
    private void bubbleDown(int i) {
        if (left(i) <= size) {
            int higherPriorityChild = left(i);
            if (right(i) <= size && compare(heap[right(i)], heap[left(i)])) {
                higherPriorityChild = right(i);
            }
            if (compare(heap[higherPriorityChild], heap[i])) {
                var priorityChild = heap[higherPriorityChild];
                heap[higherPriorityChild] = heap[i];
                heap[i] = priorityChild;
                bubbleDown(higherPriorityChild);
            }
        }
    }

    /**
     * Compares priorities of two patients.
     */
    private boolean compare(Patient a, Patient b) {
        if (a.priority != b.priority) {
            return a.priority < b.priority;
        }
        return a.name.compareTo(b.name) < 0;
    }

    /**
     * Returns whether the heap is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of the parent node
     */
    public int parent(int i) {
        return i / 2;
    }

    /**
     * Returns the index of the left child node
     */
    public int left(int i) {
        return 2 * i;
    }

    /**
     * Returns the index of the right child node
     */
    public int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the current size of the heap.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the priority of the front-most patient in the queue.
     */
    public int peekPriority() throws Error {
        if (isEmpty()) {
            throw new Error("Error: Queue is Empty");
        }
        return heap[1].priority;
    }

    /**
     * Returns the name of the front-most patient in the queue.
     */
    public String peek() throws Error {
        if (isEmpty()) {
            throw new Error("Error: Queue is Empty");
        }
        return heap[1].name;
    }

    /**
     * Prints the elements of the queue.
     */
    public String toString() {
        String s = "{";
        for (int i = 1; i <= size; i++)
            s += (i == 1 ? "" : ", ") + heap[i];
        return s + "}";
    }

    /**
     * Removes a Patient Object from the queue.
     */
    public String dequeue() throws Error {
        if (isEmpty())
            throw new Error("Error: Queue is Empty");
        var first = heap[1];
        heap[1] = heap[size];
        size--;
        bubbleDown(1);
        return first.name;
    }

    /**
     * Creates a Patient Object with the provided arguments.
     */
    public void enqueue(String name, int priority) {
        var newPatient = new Patient(name, priority);
        enqueue(newPatient);
    }

    /**
     * Adds a Patient Object to the queue.
     */
    public void enqueue(Patient patient) {
        size++;
        if (size >= heap.length) {
            resize(2 * heap.length);
        }
        heap[size] = patient;
        bubbleUp(size);
    }

    /**
     * Removes all elements in the queue.
     */
    public void clear() {
        heap = new Patient[DEFAULT_SIZE];
        heap[0] = null;
        size = 0;
    }

    /**
     * Changes the priority of a patient that actively exists in the queue.
     */
    public void changePriority(String name, int newPriority) {
        for (int i = 1; i < size + 1; i++) {
            if (heap[i].name.equals(name)) {
                heap[i].priority = newPriority;
                if (heap[parent(i)] != null && compare(heap[i], heap[parent(i)])) {
                    bubbleUp(i);
                } else {
                    bubbleDown(i);
                }
                break;
            }
        }
    }
}