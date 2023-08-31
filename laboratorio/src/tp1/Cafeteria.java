package tp1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Cafeteria {

    private LinkedBlockingQueue pedidosPendientes;
    private Barista baristas[]; //Arreglo para los baristas;
    private ScheduledExecutorService planificador; //Para avisarle a los baristas que deben trabajar
     


    //metodos del cliente
    public Pedido hacerPedido(Cliente cliente){
        Pedido pedido=null;
        Cafe c= new CafeSolo();
            
        int numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1){ //si lo quiere con leche
            c= new CafeConLeche(c);
        
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
       if(numeroRandom==1) // si lo quiere ademas con azucar 
           c= new CafeConAzucar(c);
       
        numeroRandom= (int)(1 + (Math.random() * (2-1)));
        if(numeroRandom==1) // si lo quiere con chocolate
            c= new CafeConChocolate(c);
        
        pedido= new Pedido (c,cliente);
        pedidosPendientes.offer(pedido);
        
        }
        return pedido;
    }

    public void esperarPedido(Pedido p){
        p.esperarPedido();
        System.out.println ("YA ESTA MI CAFEEE ") ;

    }


    //metodos de un planificador?

    public void planificarPreparacion (){
        //deberia ser
  
        int i=0;
        while(!pedidosPendientes.isEmpty()){

            ScheduledFuture res=planificador.schedule(baristas[i], 5, TimeUnit.SECONDS);
            Pedido pedidoListo;
            try {
                pedidoListo = (Pedido)res.get();
                //avisa al cliente que su pedido esta listo 
                pedidoListo.avisarPedidoListo();
            } catch (Exception e) {
           
                e.printStackTrace();
            } 
        
        }

    

    }


    //metodos barista
    public Pedido obtenerPedido(){
       Pedido p= (Pedido)pedidosPendientes.poll();
       return p;
    }

    

     
}



