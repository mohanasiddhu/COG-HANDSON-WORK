package day02.exercise01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> items = new HashMap<>();
    public void add(Item item){ items.put(item.getSku(), item); }
    public Item find(String sku){ return items.get(sku); }
    public void remove(String sku){ items.remove(sku); }
    public Map<String, Item> snapshot(){ return Collections.unmodifiableMap(items); }
}
