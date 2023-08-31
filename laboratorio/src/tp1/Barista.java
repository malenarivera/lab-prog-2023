package tp1;

    import java.util.concurrent.*;

/* 
  El Barista espera a que haya un pedido listo
  Si lo hay lo prepara y le avisa al cliente
  Sino espera hasta que haya uno
*/

public class Barista implements Callable {
    Cafeteria c;
    
    public Barista (Cafeteria c){
        this.c=c;
    }

   
    @Override
    public Object call() throws Exception {
        Pedido p=c.obtenerPedido();
        //lo preparaaa
        Thread.currentThread().sleep(100);
        System.out.println (Thread.currentThread().getName() + "YA  PREPARO EL CAFE");      
      
        return p;
        
    }
    
}
    
