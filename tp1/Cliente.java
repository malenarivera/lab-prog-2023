package lab-prog-2023. tp1;

import java.util.concurrent.*;

public class Cliente implements Runnable {
    Cafeteria c;

    public Cliente(Cafeteria c) {
        this.c = c;
    }

    public void run(){
       System.out.println("Soy el cliente "+Thread.currentThread().getName()+" y voy a hacer un pedido");
       c.hacerPedido();
       System.out.println("Soy el cliente "+Thread.currentThread().getName()+" y ya tengo mi pedido");
    }