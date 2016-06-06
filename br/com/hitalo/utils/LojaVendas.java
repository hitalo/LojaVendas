
package br.com.hitalo.utils;


public class LojaVendas {

    private static LojaVendas instance = null;
    
    private LojaVendas() {
    }
    
    public static LojaVendas getInstance() {
        if(instance == null)
            instance = new LojaVendas();
        
        return instance;
    }
    
    public void getCurrentDate() {
        
    }
    
}
