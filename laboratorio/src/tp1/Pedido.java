package tp1;

import java.util.concurrent.Semaphore;

public class Pedido {
    private Cafe c;
    private Cliente cliente;
    private Semaphore listo;
    private int numeroPedido;
    private static int nro=0;


    public Pedido (Cafe c, Cliente cliente){
        this.c=c;
        this.cliente=cliente;
        listo= new Semaphore(0);
        numeroPedido=this.nro;
        nro++;
    }

    public Cafe getCafe(){
        return c;
    }

    public void esperarPedido(){
        try {
            listo.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public int obtenerNumeroPedido(){
        return this.numeroPedido;
    }
    
    public void avisarPedidoListo(){
        listo.release();
    }




}
