package tp1;

public class Planificador implements Runnable {
    Cafeteria c;


    public void run (){
        while (true){
         c.planificarPreparacion();
        }
    }
}
