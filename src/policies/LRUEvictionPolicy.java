package policies;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    @Override
    public void keyAccessed(Object o) {

    }

    @Override
    public Key evictKey() {
        return null;
    }
}
