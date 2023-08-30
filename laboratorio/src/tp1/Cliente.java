package tp1;



public class Cliente implements Runnable {
    Cafeteria c;

    public Cliente(Cafeteria c) {
        this.c = c;
    }

    public void run(){
        int numeroMesa=-1;
        numeroMesa= c.sentarseEnLaMesa();
        if(numeroMesa!=-1){
            System.out.println("Soy el cliente "+Thread.currentThread().getName()+ " y voy a hacer un pedido");
            System.out.println("Soy el cliente "+Thread.currentThread().getName()+" y voy a hacer un pedido");
            c.hacerPedido();
            c.esperarPedido();
            System.out.println("Soy el cliente "+Thread.currentThread().getName()+" y ya tengo mi pedido");
            c.liberarMesa(numeroMesa);
     }
}
}
