/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;


import java.util.concurrent.*;

/**
 *
 * @author male
 * @author anto
 */

//Version 1.1 de la cafeteria

public class CafeteriaRenovada {
     private LinkedBlockingQueue pedidosPendientes; //Cola que mantiene los pedidos de los clientes
     private Cafe pedidosListos[]; //Cola para asignarle luego al cliente su pedido preparado
     private Barista baristas[]; //Arreglo para los baristas;
     private ScheduledExecutorService scheduler; //Para algo (no se para que)
     
     
     
     public void prepararPedido(){
         //Metodo usado por algo
         Cafe c; 
         int i=0;
         int j=0;
         while(!pedidosPendientes.isEmpty()){ //Vemos si la cola de pedidos no esta vacia
             c= (Cafe) pedidosPendientes.poll(); //Sacamos el primer pedido hecho
               scheduler.schedule(baristas[i], 5, TimeUnit.SECONDS); //Mandamos a un barista a hacerlo
              pedidosListos[j]=c; //Agregamos ese cafe a la cola de pedidosListos
              j++;
              if(i==baristas.length-1)
                  i=0;
              else
                  i++;
          }
     }
     
     
     
    public void hacerPedido(){
        Cafe c= new CafeSolo();
        //metodo usado por cliente;
        //hace un pedido en la cafeteria
        //el pedido es random
        
        /*----------Esto habria que hacerlo mas lindis*/
        
        int numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1){ //si lo quiere con leche
            c= new CafeConLeche(c);
        
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
       if(numeroRandom==1) // si lo quiere ademas con azucar 
           c= new CafeConAzucar(c);
       
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1) // si lo quiere con chocolate
            c= new CafeConChocolate(c);
        
       
        pedidosPendientes.offer(c);
    }
   }
    
   
    
     
    
}
