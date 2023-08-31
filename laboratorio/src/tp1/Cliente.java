package tp1;
// Antonella Torres - Malena Rivera 

/*
El cliente hace un pedido a la cafeteria y espera por este hasta que el barista
  le avise que esta listo
*/

public class Cliente implements Runnable {
    Cafeteria c;
    
    public Cliente (Cafeteria c){
        this.c=c;
    }
    


    @Override
    public void run (){
       System.out.println("Soy el cliente "+Thread.currentThread().getName()+"y voy a hacer un pedido");
       Pedido p= c.hacerPedido(this);
       c.esperarPedido(p);
       System.out.println ("Soy el cliente "+Thread.currentThread().getName()+", recibi mi pedido y me voy");
    }
}
