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
         Cafeteria c = new Cafeteria(); //Creo la cafeteria
        Barista b [] = new Barista [5]; //Creo a los baristas
        Cliente cl [] = new Cliente [20]; //Creo a los clientes
        Planificador p = new Planificador (c); // creo al planificador
        
        Thread thPlanificador = new Thread(p); //Hilo del planificador
        Thread thClientes [] = new Thread [cl.length]; //Hilo del cliente
        
        thPlanificador.run();
        
        for (int i = 0; i < b.length; i++) {
            b[i] = new Barista(c);
        }
        
        c.setearBaristas(b);
        
        
        for (int i = 0; i < cl.length; i++) {
                cl[i]= new Cliente(c);
                thClientes[i]= new Thread (cl[i], "Cliente "+i);
                thClientes[i].run();
        }
        
        thPlanificador.run();
        
        
        
        
        
      
      
    }
    
}
