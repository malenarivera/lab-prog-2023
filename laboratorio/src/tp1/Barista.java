package tp1;

    import java.util.concurrent.*;

public class Barista implements Callable {
    Cafeteria c;

   
    @Override
    public Object call() throws Exception {
        Pedido p=c.obtenerPedido();
        //lo preparaaa
        Thread.currentThread().sleep(100);
        System.out.println (Thread.currentThread().getName() + "YA  PREPARO EL CAFE");      
      
        return p;
        
    }
    
}
    
