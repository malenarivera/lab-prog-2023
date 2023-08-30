/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.concurrent.*;

public class Barista implements Callable {
    Cafeteria c;

   
    @Override
    public Object call() throws Exception {
        c.avisarPedidoListo();
        return true;
        
    }
    
}