import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long pid = ProcessHandle.current().pid();
        System.out.println("Process ID: " + pid);

        Thread.Builder builder = null;
        Store store = new Store();

        builder = Thread.ofVirtual().name("virtual worker-", 0);
//          builder = Thread.ofPlatform().name("platform worker-", 0);

        long starttime =  System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            ComputationTask task = new ComputationTask(store, i);
            Thread t1 = builder.start(task);
            t1.join();
            System.out.println(t1.getName() + " started");
        }

        Map<Integer,Integer> map = store.getStoreData();
        map.entrySet().stream()
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
        long endtime = System.currentTimeMillis();

        System.out.println("Total Computation Time - "+(endtime-starttime)+" miliseconds");
    }
}