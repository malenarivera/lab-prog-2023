package lab-prog-2023.tp1;


    import java.util.concurrent.*;

class Coffee implements Callable<String> {
    private String type;

    public Coffee(String type) {
        this.type = type;
    }

    @Override
    public String call() throws Exception {
        return "Prepared " + type + " coffee";
    }
}

class CoffeeDecorator implements Callable<String> {
    protected Callable<String> decoratedCoffee;

    public CoffeeDecorator(Callable<String> decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String call() throws Exception {
        return decoratedCoffee.call();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Callable<String> decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String call() throws Exception {
        return super.call() + " with milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Callable<String> decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String call() throws Exception {
        return super.call() + " with sugar";
    }
}

public class Cafeteria {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // Create a basic coffee
        Callable<String> basicCoffee = new Coffee("Regular");

        // Decorate the basic coffee with milk and sugar
        Callable<String> decoratedCoffee = new SugarDecorator(new MilkDecorator(basicCoffee));

        // Schedule the prepared coffee to be ready in 5 seconds
        ScheduledFuture<String> futureCoffee = executor.schedule(decoratedCoffee, 5, TimeUnit.SECONDS);

        try {
            String result = futureCoffee.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

