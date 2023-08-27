

import java.util.concurrent.*;

class Cafe implements Callable<String> {
    private String type;

    public Cafe(String type) {
        this.type = type;
    }

    @Override
    public String call() throws Exception {
        return "Prepared " + type + " Cafe";
    }
}

class CafeDecorator implements Callable<String> {
    protected Callable<String> cafeDecorated;

    public CafeDecorator(Callable<String> cafeDecorated) {
        this.cafeDecorated = cafeDecorated;
    }

    @Override
    public String call() throws Exception {
        return cafeDecorated.call();
    }
}

class cafeConLeche extends CafeDecorator {
    public cafeConLeche(Callable<String> cafeDecorated) {
        super(cafeDecorated);
    }

    @Override
    public String call() throws Exception {
        return super.call() + " with milk";
    }
}

class cafeConAzucar extends CafeDecorator {
    public cafeConAzucar(Callable<String> cafeDecorated) {
        super(cafeDecorated);
    }

    @Override
    public String call() throws Exception {
        return super.call() + " with sugar";
    }
}

public class Cafeteria {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // Create a basic Cafe
        Callable<String> basicCafe = new Cafe("Regular");

        // Decorate the basic Cafe with milk and sugar
        Callable<String> cafeDecorated = new cafeConAzucar(new cafeConLeche(basicCafe));

        // Schedule the prepared Cafe to be ready in 5 seconds
        ScheduledFuture<String> futureCafe = executor.schedule(cafeDecorated, 5, TimeUnit.SECONDS);

        try {
            String result = futureCafe.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
