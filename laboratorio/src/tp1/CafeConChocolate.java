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
public class CafeConChocolate implements Cafe{
    private Cafe cafeDecorado;
    
     public CafeConChocolate(Cafe cafeDecorado){
        this.cafeDecorado = cafeDecorado;
    }

    public String obtenerTipo() {
        return cafeDecorado.obtenerTipo()+ ", con chocolate";
    }
    
    

}
