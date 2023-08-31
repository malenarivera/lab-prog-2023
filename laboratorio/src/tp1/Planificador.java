package tp1;

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
            System.out.println(" aaaaa");
         c.esperarPorPedido();
         c.planificarPreparacion();
        }
    }
}
