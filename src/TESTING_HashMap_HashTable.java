import java.util.*;
import java.util.LinkedList;

public class TESTING_HashMap_HashTable {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("California", 30);
        map.put("Texas", 20);
        map.put("Florida", 40);
        map.put("Arizona", 10);
        map.put("Washington", 20);
        map.put("Massachusetts", 20);
        map.put("Nevada", 10);
        map.put("Oregon", 20);
        map.put("Hawaii", 2);
        map.put("Tennessee", 5);
        map.printTable();
    }

    public static void test2() {
        HashMap<Integer, Integer> names = new HashMap<>();
        System.out.println(names.isEmpty());
        names.put(21, 1024);
        names.put(33, 1024);
        names.put(18, 1024);
        names.put(31, 1024);
        names.put(26, 1024);
        names.put(14, 1024);
        names.put(19, 1024);
        names.put(22, 555);
        names.put(39, 666);
        names.put(55, 645);
        System.out.println(names.put(71, 1024));
        System.out.println(names.put(71, 9999));
        System.out.println(names.isEmpty());
        System.out.println(names.containsKey(33));
        System.out.println(names.containsValue(666));
        System.out.println(names.get(22));
        System.out.println(names.size());
        System.out.println(names.keySet());
        names.remove(31);
        names.printTable();
        names.clear();
        System.out.println(names.isEmpty());
        System.out.println();

        HashMap<String, Integer> second = new HashMap<>();
        System.out.println(second.isEmpty());
        System.out.println(second.put("Chris", 1995));
        System.out.println(second.put("Marissa", 1993));
        System.out.println(second.isEmpty());
        System.out.println(second.containsKey("Chris"));
        System.out.println(second.containsValue(1995));
        System.out.println(second.get("Chris"));
        System.out.println(second.size());
        System.out.println(second.keySet());
        second.printTable();
        second.clear();
        System.out.println(second.isEmpty());
        System.out.println();

        HashTable<Integer, Integer> runs = new HashTable<>();
        System.out.println(runs.hashTable.size());
    }

    public static void test3() {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("New York");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        for (String s : set)
            System.out.print(s.toUpperCase() + " ");
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }

    public static void test4() {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Should be True ===== " + map.isEmpty());
        map.printTable();

        map.put(21, 30);
        map.put(68, 25);
        map.put(24, 40);
        map.put(70, 20);
        map.put(40, 22);
        map.put(100, 10);
        map.put(151, 21);
        map.put(1, 2);
        map.put(30, 5);

        System.out.println();
        System.out.println(map.keySet());
        System.out.println();
        System.out.println("Should be True ===== " + map.containsKey(21));
        System.out.println("Should be True ===== " + map.containsKey(68));
        System.out.println("Should be True ===== " + map.containsKey(24));
        System.out.println("Should be True ===== " + map.containsKey(70));
        System.out.println("Should be True ===== " + map.containsKey(40));
        System.out.println("Should be True ===== " + map.containsKey(100));
        System.out.println("Should be True ===== " + map.containsKey(151));
        System.out.println("Should be True ===== " + map.containsKey(1));
        System.out.println("Should be True ===== " + map.containsKey(30));

        System.out.println("Should be False ===== " + map.containsKey(42));
        System.out.println("Should be False ===== " + map.containsKey(9));
        System.out.println("Should be False ===== " + map.containsKey(11));
        System.out.println("Should be False ===== " + map.containsKey(0));
        System.out.println("Should be False ===== " + map.containsKey(-2));
        System.out.println("Should be 30 ===== " + map.get(21));

        map.put(21, 7);
        System.out.println("Should be False ===== " + map.containsValue(30));
        System.out.println("Should be True ===== " + map.containsKey(21));
        System.out.println("Should be True ===== " + map.containsValue(7));
        System.out.println("Should be 7 ===== " + map.get(21));

        System.out.println("Should be True ===== " + map.containsValue(7));
        System.out.println("Should be True ===== " + map.containsValue(20));
        System.out.println("Should be True ===== " + map.containsValue(40));
        System.out.println("Should be True ===== " + map.containsValue(10));
        System.out.println("Should be True ===== " + map.containsValue(2));
        System.out.println("Should be True ===== " + map.containsValue(5));
        System.out.println("Should be True ===== " + map.containsValue(25));
        System.out.println("Should be True ===== " + map.containsValue(22));
        System.out.println("Should be True ===== " + map.containsValue(21));

        System.out.println("Should be False ===== " + map.containsValue(1));
        System.out.println("Should be False ===== " + map.containsValue(29));
        System.out.println("Should be False ===== " + map.containsValue(31));
        System.out.println("Should be False ===== " + map.containsValue(12));
        System.out.println("Should be False ===== " + map.containsValue(-2));

        System.out.println("Should be False ===== " + map.isEmpty());

        System.out.println("Should be 9 ==== " + map.size());
        map.put(140, 99);
        System.out.println("Should be 10 ==== " + map.size());
        map.put(150, 111);
        System.out.println("Should be 11 ==== " + map.size());
        map.remove(68);
        System.out.println("Should be False ===== " + map.containsValue(25));
        System.out.println("Should be True ===== " + map.containsValue(111));
        System.out.println("Should be 10 ==== " + map.size());
        map.remove(140);
        System.out.println("Should be 9 ==== " + map.size());

        System.out.println();
        map.printTable();
        System.out.println();

        map.clear();
        System.out.println("Should be True ===== " + map.isEmpty());
        System.out.println();

        System.out.println("Should be empty table");
        map.printTable();
    }
}

class HashMap<K, V> {
    HashTable<K, V> map;

    /**
     * Constructor
     */
    public HashMap() {
        map = new HashTable<>();
    }

    /**
     * Associates the specified value with the specified key in this map.
     */
    public V put(K key, V value) {
        return map.put(key, value);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     */
    public V remove(K key) {
        return map.remove(key);
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    /**
     * Returns true if this hashmap maps one or more keys to the specified value.
     */
    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public V get(K key) {
        return map.getValue(key);
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    public int size() {
        return map.size();
    }

    /**
     * Removes all the mappings from this map.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public java.util.Set<K> keySet() {
        return map.getKeySet();
    }

    /**
     * Outputs how many conflicts occur at each bucket and list the keys in that bucket.
     */
    public void printTable() {
        map.printTable();
    }
}

class Node<K, V> {
    K key;
    V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V> {
    final static int TABLE_SIZE = 8;
    ArrayList<LinkedList<Node<K, V>>> hashTable = new ArrayList<>(TABLE_SIZE);
    HashSet<K> keySet = new HashSet<>();
    HashSet<V> valueSet = new HashSet<>();

    public HashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    /**
     * Associates the specified value with the specified key in this map.
     */
    public V put(K key, V value) {
        if (hashTable.get(hash(key)).size() != 0) {
            var list = hashTable.get(hash(key));
            for (Node<K, V> node : list) {
                if (node.key.equals(key)) {
                    var oldValue = node.value;
                    valueSet.remove(oldValue);
                    valueSet.add(value);
                    node.value = value;
                    return oldValue;
                }
            }
        }
        hashTable.get(hash(key)).addFirst(new Node<>(key, value));
        keySet.add(key);
        valueSet.add(value);
        return null;
    }

    /**
     * Hash function used to generate the index for array storage.
     */
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % TABLE_SIZE;
        return Math.abs(index);
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     */
    public V remove(K key) {
        if (hashTable.get(hash(key)).size() != 0) {
            var list = hashTable.get(hash(key));
            for (Node<K, V> node : list) {
                if (key.equals(node.key)) {
                    var oldValue = node.value;
                    list.remove(node);
                    keySet.remove(key);
                    valueSet.remove(oldValue);
                    return oldValue;
                }
            }
        }
        return null;
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(K key) {
        return keySet.contains(key);
    }

    /**
     * Returns true if this hashmap maps one or more keys to the specified value.
     */
    public boolean containsValue(V value) {
        return valueSet.contains(value);
    }

    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {
        return (keySet.isEmpty() && valueSet.isEmpty());
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the
     * key.
     */
    public V getValue(K key) {
        var list = hashTable.get(hash(key));
        for (Node<K, V> node : list) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     */
    public int size() {
        int total = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            total += list.size();
        }
        return total;
    }

    /**
     * Removes all the mappings from this map.
     */
    public void clear() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            list.clear();
        }
        keySet.clear();
        valueSet.clear();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public Set<K> getKeySet() {
        return keySet;
    }

    /**
     * Outputs how many conflicts occur at each bucket and list the keys in that bucket.
     */
    public void printTable() {
        int totalConflicts = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            var list = hashTable.get(i);
            var conflicts = new ArrayList<>();
            for (Node<K, V> node : list) {
                conflicts.add(node.key.toString());
            }
            if (conflicts.size() > 0) {
                conflicts.set(conflicts.size() - 1, conflicts.get(conflicts.size() - 1) + ", ");
            }
            if (conflicts.size() <= 1) {
                System.out.println("Index " + i + ": (" + 0 + " conflicts)," + conflicts);
            } else {
                System.out.println("Index " + i + ": (" + (list.size() - 1) + " conflicts)," + conflicts);
                totalConflicts += (list.size() - 1);
            }
        }
        System.out.println("Total # of conflicts: " + totalConflicts);

    }
}