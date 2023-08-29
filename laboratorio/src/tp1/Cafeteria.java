/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author male_
 */
public class Cafeteria {
    private LinkedBlockingQueue pedidosPendientes;
   private ScheduledExecutorService scheduler; //manda a un hilo a trabajar dps de un tiempo
            //el hilo seria el callable --> el barista
            //el callable devuelve algo --> teoricamente seria el cafe pero weno eso dps se ve
            //aca es donde tendria que tener el schedule entonces
   private Barista baristas[];
   

   
    public Cafeteria(int cantBaristas){
        pedidosPendientes= new LinkedBlockingQueue();
        scheduler= Executors.newScheduledThreadPool(cantBaristas);
      
        for (int i = 0; i < baristas.length; i++) {
            Barista barista = baristas[i];
        }
                
    }
    
    
    public void hacerPedido(){
        Cafe c= new CafeSolo();
        //metodo usado por cliente;
        //hace un pedido en la cafeteria
        //el pedido es random
        
        
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
    
    public void esperarPedido(){
        //EL CLIENTE DEBERIA ESPERAR POR EL PEDIDO
    }
    
    
    public void prepararPedido(){
        //Metodo usado por el barista
        //
        Cafe c;
       for (Barista barista : baristas) {
            c =  (Cafe) pedidosPendientes.poll();
            if (c != null) {
                scheduler.schedule(barista, 5, TimeUnit.SECONDS); //tarda 5 segundos en preparar el cafe!!
            }
        }
    }
    
    public void avisarPedidoListo(){
        //el barista deberia avisarle al cliente q su pedido ya esta listo :)
    }
    
}
