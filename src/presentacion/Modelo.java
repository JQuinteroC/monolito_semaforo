package presentacion;

import logica.Semaforo;

import java.awt.*;


public class Modelo implements Runnable{

    private Semaforo sistema;
    private Vista ventana;
    private final int ROJO = 0;
    private final int AMARILLO = 1;
    private final int VERDE = 2;

    public void iniciar() {
        // codigo de inicio de app
        getVentana().setSize(300, 250);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);
    }

    public Semaforo getSistema() {
        if(sistema == null){
            sistema = new Semaforo();
        }
        return sistema;
    }    

    public Vista getVentana() {
        if(ventana == null){
            ventana = new Vista(this);
        }
        return ventana;
    }

    public void registrarTemperaturaAmbiente() {
        // informe al sistema que la temperatura ambiente cambió
        float v = getVentana().getSliTemp().getValue();
        getSistema().setTemperaturaActual(v);

        getVentana().getPbrTemperatura().setValue((int) getSistema().getTemperaturaActual());
        getVentana().getLblTemperatura().setText("" + getSistema().getTemperaturaActual());
    }

    public void cambioEstado() {
        if(getSistema().getEstado() == 0) {
            getSistema().setEstado(2);
            // Encendido
            getVentana().getLed1().setBackground(new Color(255, 0, 0));
            // Apagado
            getVentana().getLed2().setBackground(new Color(186, 186, 0));
            // Apagado
            getVentana().getLed3().setBackground(new Color(0, 145, 0));
        }
        if(getSistema().getEstado() == 2) {
            getSistema().setEstado(0);
            // Apagado
            getVentana().getLed1().setBackground(new Color(186, 0, 0));
            // Apagado
            getVentana().getLed2().setBackground(new Color(255, 0, 0));
            // Encendido
            getVentana().getLed3().setBackground(new Color(0, 204, 0));
        }

    }

    @Override
    public void run() {

    }
}
