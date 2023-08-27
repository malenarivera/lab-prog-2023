/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

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
        //metodo usado por cliente;
        //hace un pedido en la cafeteria
        //el pedido es random
        pedidosPendientes.offer(new Pedido());
    }
    
    public Pedido atenderPedido(){
        
    }
}
