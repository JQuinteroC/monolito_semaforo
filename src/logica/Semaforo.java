package logica;

import java.util.ArrayList;

public class Semaforo {

    private ArrayList<Led> leds;
    private int estado;
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

}
