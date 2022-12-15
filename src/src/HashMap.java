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
