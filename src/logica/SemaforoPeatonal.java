package logica;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class SemaforoPeatonal extends Semaforo {

    private ImageIcon imgGreenOn = new ImageIcon(new ImageIcon("resources/img/green_on.png")
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
    private ImageIcon imgGreenOff = new ImageIcon(new ImageIcon("resources/img/green_off.png")
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
    private ImageIcon imgRedOn = new ImageIcon(new ImageIcon("resources/img/red_on.png")
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));;
    private ImageIcon imgRedOff = new ImageIcon(new ImageIcon("resources/img/red_off.png")
            .getImage()
            .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));;
    
    @Override
    public void cambioEstadoAmarillo(int estado){
        
    }
    
    @Override
    public void cambioEstadoRojo(int estado) {
        if (estado == 1) {
            leds.get(0).getLbl().setIcon(imgRedOn);
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(0).setEstado(1);
        } else if (estado == 0) {
            leds.get(0).getLbl().setIcon(imgRedOff);
            // comunicarEstado("estado botón rojo -> 0");
            leds.get(0).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }
    
    @Override
    public void cambioEstadoVerde(int estado) {
        if (estado == 1) {
            leds.get(1).getLbl().setIcon(imgGreenOn);
            // comunicarEstado("estado botón rojo -> 1");
            leds.get(1).setEstado(1);
        } else if (estado == 0) {
            leds.get(1).getLbl().setIcon(imgGreenOff);
            // comunicarEstado("estado botón rojo -> 0");
            leds.get(1).setEstado(0);
        } else {
            // led dañado
            // comunicarEstado("estado botón rojo -> dañado");
        }

    }

}
