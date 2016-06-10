
package br.com.hitalo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class LojaVendas {

    private static LojaVendas instance = null;
    
    private LojaVendas() {
    }
    
    public static LojaVendas getInstance() {
        if(instance == null)
            instance = new LojaVendas();
        
        return instance;
    }
    
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
}
