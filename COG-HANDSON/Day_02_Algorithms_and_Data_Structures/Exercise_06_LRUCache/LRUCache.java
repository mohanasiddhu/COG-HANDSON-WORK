package day02.exercise06;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private final LinkedHashMap<K,V> map;
    public LRUCache(int capacity){
        this.map = new LinkedHashMap<K,V>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest){ return size() > capacity; }
        };
    }
    public synchronized void put(K k,V v){ map.put(k,v); }
    public synchronized V get(K k){ return map.get(k); }
    @Override public String toString(){ return map.toString(); }
}
