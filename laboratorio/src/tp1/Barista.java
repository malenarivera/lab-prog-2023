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
    public Pedido call() throws Exception {
        Pedido p=c.obtenerPedido(); 
        System.out.println("Barista obtuvo el pedido "+p.obtenerNumeroPedido());
        //lo preparaaa
        Thread.sleep(100);
        System.out.println ("Se termino de preparar el pedido "+p.obtenerNumeroPedido());      
      
        return p;
        
    }
    
}
    
