package logica;

import java.awt.Color;
import java.util.ArrayList;

public class SemaforoPeatonal extends Semaforo{
    
    public void cambioEstadoVerde(int estado) {
        if (estado == 1) {
            leds.get(1).getLbl().setBackground(new Color(0, 204, 0));
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(1).setEstado(1);
        } else if (estado == 0) {
            leds.get(1).getLbl().setBackground(new Color(0, 145, 0));
            // comunicarEstado("estado botón rojo -> 0");
             leds.get(1).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }
    
}
