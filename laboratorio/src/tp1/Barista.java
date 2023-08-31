package tp1;

    import java.util.concurrent.*;

/* 
  El Barista espera a que haya un pedido listo
  Si lo hay lo prepara y le avisa al cliente
  Sino espera hasta que haya uno
*/

public class Barista implements Callable {
    Cafeteria c;
    String nombre;
    
    public Barista (Cafeteria c, int i){
        this.c=c;
        nombre = "Barista "+i;
    }

   
    @Override
    public Pedido call() throws Exception {
        Pedido p=c.obtenerPedido(); 
        System.out.println(nombre+" obtuvo el pedido "+p.obtenerNumeroPedido());
        //lo preparaaa
        Thread.sleep(100);
        System.out.println ("Se termino de preparar el pedido "+p.obtenerNumeroPedido()+'\n'); 
        return p;
        
    }
    
}
    
