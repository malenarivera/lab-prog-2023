package tp1;

public class Cliente implements Runnable {
    CafeteriaR c;
    


    public void run (){
       Pedido p= c.hacerPedido(this);
       c.esperarPedido(p);
       System.out.println ("ME VOY");


    }
}
