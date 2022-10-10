package logica;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Semaforo {

    ArrayList<Led> leds;
    private int estado;
    private Thread hilo;
    // 0 - Funcional
    // 1 - Dañado

    public Semaforo() {
        estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Led> getLeds() {
        return leds;
    }

    public void setLeds(ArrayList leds) {
        this.leds = leds;
    }

    public Thread getHilo() {
        if (hilo == null){
            hilo = new Thread();
        }
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }
    
    

    public void cambioEstadoRojo(int estado) {
        if (estado == 1) {
            leds.get(0).getLbl().setBackground(new Color(255, 0, 0));
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(0).setEstado(1);
        } else if (estado == 0) {
            leds.get(0).getLbl().setBackground(new Color(100, 0, 0));
            // comunicarEstado("estado botón rojo -> 0");
            leds.get(0).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }
    
    public void cambioEstadoAmarillo(int estado) {
        if (estado == 1) {
            leds.get(1).getLbl().setBackground(new Color(255, 255, 0));
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(1).setEstado(1);
        } else if (estado == 0) {
            leds.get(1).getLbl().setBackground(new Color(100, 100, 0));
            // comunicarEstado("estado botón rojo -> 0");
             leds.get(1).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }
    
    public void cambioEstadoVerde(int estado) {
        if (estado == 1) {
            leds.get(2).getLbl().setBackground(new Color(0, 204, 0));
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(2).setEstado(1);
        } else if (estado == 0) {
            leds.get(2).getLbl().setBackground(new Color(0, 100, 0));
            // comunicarEstado("estado botón rojo -> 0");
             leds.get(2).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }

}
