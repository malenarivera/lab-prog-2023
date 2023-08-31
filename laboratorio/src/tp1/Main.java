/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author male_
 */
public class Main {
    public static void main(String[] args) {
         Cafeteria c = new Cafeteria(5); //Creo la cafeteria
        Cliente cl [] = new Cliente [20]; //Creo a los clientes
        Planificador p = new Planificador (c); // creo al planificador
        
        Thread thPlanificador = new Thread(p); //Hilo del planificador
        Thread thClientes [] = new Thread [cl.length]; //Hilo del cliente
        
        
        for (int i = 0; i < cl.length; i++) {
                cl[i]= new Cliente(c);
                thClientes[i]= new Thread (cl[i], "Cliente "+i);
                thClientes[i].start();
        }
        
        
        thPlanificador.start();
        
        
        
        
        
        
      
      
    }
    
}
