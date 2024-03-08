import policies.EvictionPolicy;
import storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;
    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) throws Exception {
        try{
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch ( Exception e){
            Key keyToRemove = evictionPolicy.evictKey();
            if (null == key){
                throw new Exception("Not able to remove key when storage is full. Invalid State !!");
            }
            storage.removeKey(keyToRemove);
            put(key, value);
        }

    }

    public Value get(Key key){
        try{
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }catch (Exception e){
            System.out.println("Tried to access non existing key!!");
            return null;
        }
    }

}
