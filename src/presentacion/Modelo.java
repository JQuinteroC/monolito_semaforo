package presentacion;

import logica.Semaforo;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Modelo {

    private Semaforo sistema;
    private Vista ventana;
    private final int ROJO = 0;
    private final int AMARILLO = 1;
    private final int VERDE = 2;
    private Timer timer;

    public void iniciar() {
        // codigo de inicio de app
        getVentana().setSize(300, 250);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);

        timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                encenderColor(getSistema().getEstado());
                timer.stop();
            }
        });

    }

    public Semaforo getSistema() {
        if (sistema == null) {
            sistema = new Semaforo();
        }
        return sistema;
    }

    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }

    public void cambioEstado() throws InterruptedException {
        
        if (getSistema().getEstado() == 0) {
            
            getSistema().setEstado(1);
            encenderColor(getSistema().getEstado());
            
            // Encendido
            //getVentana().getLed1().setBackground(new Color(186, 0, 0));
            // Apagado
            //getVentana().getLed2().setBackground(new Color(255, 255, 0));
            // Apagado
            //getVentana().getLed3().setBackground(new Color(0, 145, 0));
            timer.start();
            getSistema().setEstado(2);
            timer.start();
            

        } else if (getSistema().getEstado() == 2) {
            getSistema().setEstado(1);
            encenderColor(getSistema().getEstado());
            // Apagado
            //getVentana().getLed1().setBackground(new Color(255, 0, 0));
            // Apagado
            //getVentana().getLed2().setBackground(new Color(186, 186, 0));
            // Encendido
            //getVentana().getLed3().setBackground(new Color(0, 145, 0));
            timer.start();
            getSistema().setEstado(0);
            timer.start();
        }

    }
    
    public void encenderColor(int estado){
        System.out.println(getSistema().getEstado());
        if (estado == 0){
            //Prender el rojo
            getVentana().getLed1().setBackground(new Color(255, 0, 0));
            //Apagar el amarillo
            getVentana().getLed2().setBackground(new Color(186, 186, 0));
            //Apagar el verde
            getVentana().getLed3().setBackground(new Color(0, 145, 0));
        } else if (estado == 1){
            //Apagar el rojo
            getVentana().getLed1().setBackground(new Color(186, 0, 0));
            //Prender el amarillo
            getVentana().getLed2().setBackground(new Color(255, 255, 0));
            //Apagar el verde
            getVentana().getLed3().setBackground(new Color(0, 145, 0));
        } else {
            //Apagar el rojo
            getVentana().getLed1().setBackground(new Color(186, 0, 0));
            //Apagar el amarillo
            getVentana().getLed2().setBackground(new Color(186, 186, 0));
            //Prender el verde
            getVentana().getLed3().setBackground(new Color(0, 204, 0));
        }
    }

}
