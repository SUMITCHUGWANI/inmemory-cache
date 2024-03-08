package storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key, Value> mp = new HashMap<>();
    @Override
    public void add(Key key, Value value) {
        mp.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return mp.get(key);
    }

    @Override
    public void removeKey(Key keyToRemove) {
        mp.remove(keyToRemove);
    }
}
