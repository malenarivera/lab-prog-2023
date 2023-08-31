package tp1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Clase que se usa como Recurso-Compartido entre Barista y Cliente
*/

public class Cafeteria {

    private LinkedBlockingQueue pedidosPendientes; //Buffer compartido por los baristas que contiene los pedidos pendientes.
    private Barista baristas[]; //Arreglo para los baristas;
    private ScheduledExecutorService planificador; //Para que cada barista prepare un pedido
    private Semaphore avisarPedido; //Semaforo que sirve para avisarle al barista que hay un pedido listo
    
  
    
    public Cafeteria (int cantBaristas){
        pedidosPendientes = new LinkedBlockingQueue();
        avisarPedido= new Semaphore(0);
        baristas= new Barista[cantBaristas];
        for (int i = 0; i < baristas.length; i++) {
            baristas[i]= new Barista(this);
        }
        planificador=  Executors.newScheduledThreadPool(cantBaristas);
    }
     


    //metodos del cliente
    
   
    public Pedido hacerPedido(Cliente cliente){
        //Metodo usado por el cliente
        //Se aplica la logica del patron Decorator
        Pedido pedido=null;
        Cafe c= new CafeSolo();
            
        int numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1) //si lo quiere con Leche
            c= new CafeConLeche(c);
        
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
       if(numeroRandom==1) // si lo quiere ademas con azucar 
           c= new CafeConAzucar(c);
       
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1) // si lo quiere con chocolate
            c= new CafeConChocolate(c);
        
        pedido= new Pedido (c,cliente); //Se crea el pedido con el cafe elegido y el cliente que lo pidio
        pedidosPendientes.offer(pedido); //Se agrega el pedido al buffer
        avisarPedido.release(); //avisa que hizo un pedido
        return pedido;
    }

    public void esperarPedido(Pedido p){
        p.esperarPedido();
    }


    //metodos de un planificador?
    
     public void esperarPorPedido(){
        // Para que el barista no haga espera activa espera en este semaforo
        try {
            avisarPedido.acquire(); 
        } catch (InterruptedException ex) {
            Logger.getLogger(Cafeteria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void planificarPreparacion () throws ExecutionException, InterruptedException{
        //deberia ser
        int j=0;
       while(j<baristas.length && !pedidosPendientes.isEmpty()){
           ScheduledFuture res= planificador.schedule(baristas[j], 5, TimeUnit.SECONDS); //Le envia la tarea al barista
            Pedido pedidoListo;
                pedidoListo= (Pedido) res.get();
                pedidoListo.avisarPedidoListo();
                
             if(j++==baristas.length)
                 j=0;
             else
               j++;
          }
       }

    


    //metodos barista
    
    public Pedido obtenerPedido(){
       Pedido p= (Pedido)pedidosPendientes.poll();
       return p;
    }

    

     
}



