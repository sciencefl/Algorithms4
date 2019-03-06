package algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Integer> map;
	private int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        	return  map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
