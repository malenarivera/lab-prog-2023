package tp1;
// Antonella Torres - Malena Rivera 

/*
El cliente hace un pedido a la cafeteria y espera por este hasta que el barista
  le avise que esta listo
*/

public class Cliente implements Runnable {
    private Cafeteria c;
    
    public Cliente (Cafeteria c){
        this.c=c;
    }
    


    @Override
    public void run (){
       Pedido p= c.hacerPedido(this);
        System.out.println("Cliente "+Thread.currentThread().getName()+" hizo el pedido nro"+p.obtenerNumeroPedido());
       c.esperarPedido(p);
       System.out.println ("Soy el cliente "+Thread.currentThread().getName()+" y recibi mi pedido con nro" +p.obtenerNumeroPedido());
    }
}
