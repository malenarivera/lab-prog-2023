/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author male
 * @author anto
 */
public class Cafeteria {
    private LinkedBlockingQueue pedidosPendientes;
   private ScheduledExecutorService scheduler; //manda a un hilo a trabajar dps de un tiempo
            //el hilo seria el callable --> el barista
            //el callable devuelve algo --> teoricamente seria el cafe pero weno eso dps se ve
            //aca es donde tendria que tener el schedule entonces
   private Barista baristas[];
   private Semaphore mesas[]; //Los clientes se sientan en las mesas y de ahi llaman al barista
   private Semaphore avisarBarista; //Con este semaforo es que lo llaman
   

   
    public Cafeteria(int cantBaristas, int cantMesas){
        pedidosPendientes= new LinkedBlockingQueue();
        scheduler= Executors.newScheduledThreadPool(cantBaristas);
      
        for (int i = 0; i < baristas.length; i++) {
            Barista barista = baristas[i];
        }
        
        for (int i = 0; i < mesas.length; i++) {
           mesas[i] = new Semaphore(1);
        }
                
    }
    
    public int sentarseEnLaMesa(){
        //Llega el cliente y busca por una mesa libre, si hay alguna se sienta
        //Sino se va de la cafeteria porque significa que esta llena
        
        int numeroMesa=-1;
        for (int i = 0; i < mesas.length; i++) {
            //busca una mesa libre
            if(mesas[i].tryAcquire())
                numeroMesa=i;
        }
        return numeroMesa;
    }
    
    public void liberarMesa(int numeroMesa){
        mesas[numeroMesa].release();
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
