import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {

    private ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<Integer, Integer>();

    public synchronized void addQuantity(int productId){
        int key = productId % 2;
        concurrentHashMap.computeIfAbsent(key,k->0);
        concurrentHashMap.computeIfPresent(key,(k,v)->v+1);
    }

    public Map<Integer, Integer> getStoreData(){
        return concurrentHashMap;
    }
}
