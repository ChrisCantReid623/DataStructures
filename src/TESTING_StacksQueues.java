public class TESTING_StacksQueues {
    public static void main(String[] args) {
        ListStackTestRun();
        ListQueueTestRun();
        ArrayStackTestRun();
        ArrayQueueTestRun();
    }

    public static void ListStackTestRun() {
        ListStack testObject = new ListStack();
        for (int i = 1; i < 10; i++) {
            testObject.push(i);
        }

        ListStack deepCopy = new ListStack(testObject);
        ListStackTests(testObject, deepCopy);

    }

    public static void ListStackTests(ListStack testObject, ListStack deepCopy) {
        System.out.println("-------------------------------");
        System.out.println("Testing " + testObject.getClass());
        System.out.println("-------------------------------");

        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.push(44);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.clear();
        testObject.clear();
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        testObject.push(9);
        testObject.push(11);
        deepCopy.push(9);
        deepCopy.push(11);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
    }

    public static void ListQueueTestRun() {
        ListQueue testObject = new ListQueue();

        for (int i = 1; i < 10; i++) {
            testObject.enqueue(i);
        }
        ListQueue deepCopy = new ListQueue(testObject);
        ListQueueTests(testObject, deepCopy);
    }

    public static void ListQueueTests(ListQueue testObject, ListQueue deepCopy) {
        System.out.println("-------------------------------");
        System.out.println("Testing " + testObject.getClass());
        System.out.println("-------------------------------");

        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.enqueue(44);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.clear();
        testObject.clear();
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        testObject.enqueue(9);
        testObject.enqueue(11);
        deepCopy.enqueue(9);
        deepCopy.enqueue(11);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
    }

    public static void ArrayStackTestRun() {
        ArrayStack testObject = new ArrayStack();
        for (int i = 1; i < 10; i++) {
            testObject.push(i);
        }

        ArrayStack deepCopy = new ArrayStack(testObject);
        ArrayStackTests(testObject, deepCopy);
    }

    public static void ArrayStackTests(ArrayStack testObject, ArrayStack deepCopy) {
        System.out.println("-------------------------------");
        System.out.println("Testing " + testObject.getClass());
        System.out.println("-------------------------------");

        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.push(44);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.clear();
        testObject.clear();
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        testObject.push(9);
        testObject.push(11);
        deepCopy.push(9);
        deepCopy.push(11);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
    }

    public static void ArrayQueueTestRun() {
        ArrayQueue testObject = new ArrayQueue();

        for (int i = 1; i < 10; i++) {
            testObject.enqueue(i);
        }
        ArrayQueue deepCopy = new ArrayQueue(testObject);
        ArrayQueueTests(testObject, deepCopy);
    }

    public static void ArrayQueueTests(ArrayQueue testObject, ArrayQueue deepCopy) {
        System.out.println("-------------------------------");
        System.out.println("Testing " + testObject.getClass());
        System.out.println("-------------------------------");

        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.enqueue(44);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        deepCopy.clear();
        testObject.clear();
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
        System.out.println("-------------------------------");

        testObject.enqueue(9);
        testObject.enqueue(11);
        deepCopy.enqueue(9);
        deepCopy.enqueue(11);
        System.out.println("Original: " + testObject);
        System.out.println("Original Size: " + testObject.size());
        System.out.println("Empty: " + testObject.isEmpty());
        System.out.println("Next Out: " + testObject.peek());
        System.out.println();
        System.out.println("Clone: " + deepCopy);
        System.out.println("Clone Size: " + deepCopy.size());
        System.out.println("Empty: " + deepCopy.isEmpty());
        System.out.println("Next Out: " + deepCopy.peek());
        System.out.println();
        System.out.println("Equal: " + testObject.equals(deepCopy));
    }
}