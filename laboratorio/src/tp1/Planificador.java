package tp1;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Clase aparte que ejecuta la logica del ScheduledExecutorService
*/

public class Planificador implements Runnable {
    Cafeteria c;
    
    public Planificador (Cafeteria c){
        this.c=c;
    }


    public void run (){
        while (true){
            try {
                c.esperarPorPedido();
                c.planificarPreparacion();
            } catch (ExecutionException ex) {
                Logger.getLogger(Planificador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Planificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
