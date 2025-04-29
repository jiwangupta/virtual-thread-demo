import java.util.concurrent.ConcurrentHashMap;

public class ComputationTask implements Runnable{



    int productId;
    Store store;

    public ComputationTask(Store store, int id){
        this.store = store;
        productId=id;
    }

    @Override
    public void run() {
        store.addQuantity(productId);

    }
}
