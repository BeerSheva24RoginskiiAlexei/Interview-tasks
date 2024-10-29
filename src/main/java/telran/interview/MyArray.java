package telran.interview;

import java.util.HashMap;
import java.util.Map;

public class MyArray<T> {

    private Map<Integer, T> map;
    private T defaultValue;
    private boolean isSetAll;

    public MyArray(int size) {
        map = new HashMap<>(size);
        defaultValue = null;
        isSetAll = false;
    }

    public void setAll(T value) {
        defaultValue = value;
        map.clear(); 
        isSetAll = true;
    }


    public void set(int index, T value) {
        map.put(index, value);
    }


    public T get(int index) {
        if (isSetAll && !map.containsKey(index)) {
            return defaultValue; 
        }
        return map.getOrDefault(index, defaultValue);
    }
}
