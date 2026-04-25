package com.engineering.map;

import java.util.HashMap;
import java.util.Map;

public class BiMap<K,V> {

    private Map<K,V> keyMap;
    private Map<V,K> valueMap;

    public BiMap() {
        this.keyMap = new HashMap<>();
        this.valueMap = new HashMap<>();
    }

    /*
    * This is the core of BiMap. It keeps both maps in sync.
    * Ensures 1-to-1 relationship (no duplicate values)
    * If key already exists → old value removed from valueMap
    * If value already exists → old key removed from keyMap
    *
    */
    public void put(K key, V value) {
        if(keyMap.containsKey(key)){
            V oldValue = keyMap.get(key);
            valueMap.remove(oldValue);
        }
        if(valueMap.containsKey(value)){
            K oldKey = valueMap.get(value);
            keyMap.remove(oldKey);
        }
        keyMap.put(key, value);
        valueMap.put(value, key);
    }

    public V getValue(K key) {
        return keyMap.get(key);
    }

    // O(1) lookup ✅ because of this else in normal map it would be O(n) to find key by value
    public K getKey(V value) {
        return valueMap.get(value);
    }

    //reverse map becomes inconsistent ❌ if we only remove from one map,
    // so we need to remove from both maps to maintain consistency
    public void removeByKey(K key) {
        V valueToBeRemoved = keyMap.remove(key);
        if(valueToBeRemoved != null){
            valueMap.remove(valueToBeRemoved);
        }
    }
    public void removeByValue(V value) {
        K keyToBeRemove = valueMap.remove(value);
        if(keyToBeRemove != null){
            keyMap.remove(keyToBeRemove);
        }
    }


    static void main() {
        BiMap<String, Integer> biMap = new BiMap<>();
        biMap.put("One", 1);
        biMap.put("Two", 2);
        biMap.put("Three", 3);

        System.out.println(biMap.getValue("Two")); // Output: 2
        System.out.println(biMap.getKey(3)); // Output: "Three"

        biMap.removeByKey("One");
        System.out.println(biMap.getValue("One")); // Output: null

        biMap.removeByValue(2);
        System.out.println(biMap.getKey(2)); // Output: null
    }
}
