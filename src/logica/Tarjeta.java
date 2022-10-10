package logica;

import java.awt.Color;
import presentacion.Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Tarjeta {

    private Modelo modelo;

    private final ArrayList<Semaforo> gprSemaforico1;
    private final ArrayList<Semaforo> gprSemaforico2;
    private ArrayList<Semaforo> gprActivo;
    private int identificador;

    public Tarjeta(Modelo modelo) {
        this.modelo = modelo;
        gprSemaforico1 = new ArrayList<Semaforo>();
        gprSemaforico2 = new ArrayList<Semaforo>();
        gprActivo = gprSemaforico1;
    }

    public ArrayList<Semaforo> getGrupo() {
        return gprActivo;
    }

    public void changeGrupo(int index) {
        if (index == 0) {
            gprActivo = gprSemaforico1;
        } else if (index == 1) {
            gprActivo = gprSemaforico2;
        }
    }

    public void setNewGrupo(Semaforo[] gprSemaforico) {
        if (gprSemaforico1.isEmpty()) {
            for (int i = 0; i < gprSemaforico.length; i++) {
                Semaforo semaforo = gprSemaforico[i];
                gprSemaforico1.add(semaforo);
            }
        } else if (gprSemaforico2.isEmpty()) {
            for (int i = 0; i < gprSemaforico.length; i++) {
                Semaforo semaforo = gprSemaforico[i];
                gprSemaforico2.add(semaforo);
            }
        }
    }

    public void cambioEstadoRojo(int estado) {
        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            Led ledRojo = (Led) semaforoActivo.getLeds().get(0);

            if (estado == 1) {
                ledRojo.getLbl().setBackground(new Color(255, 0, 0));
                // comunicarEstado("estado botón rojo -> 1");
                ledRojo.setEstado(1);
            } else if (estado == 0) {
                ledRojo.getLbl().setBackground(new Color(186, 0, 0));
                // comunicarEstado("estado botón rojo -> 0");
                ledRojo.setEstado(0);
            } else {
                // led dañado
                // comunicarEstado("estado botón rojo -> dañado");
            }
        }
    }

    public void cambioEstadoAmarillo() {
        for (Iterator<Semaforo> iterator = gprActivo.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            Led ledAmarillo = (Led) semaforoActivo.getLeds().get(1);

            if (ledAmarillo.getEstado() == 0) {
                ledAmarillo.getLbl().setBackground(new Color(255, 255, 0));
                // comunicarEstado("estado botón amarillo -> 1");
                ledAmarillo.setEstado(1);
            } else if (ledAmarillo.getEstado() == 1) {
                ledAmarillo.getLbl().setBackground(new Color(186, 186, 0));
                // comunicarEstado("estado botón amarillo -> 0");
                ledAmarillo.setEstado(0);
            } else {
                // led dañado
                // comunicarEstado("estado botón amarillo -> dañado");
            }
        }
    }

    public void cambioEstadoVerde() {
        for (Iterator<Semaforo> iterator = gprSemaforico1.iterator(); iterator.hasNext();) {
            Semaforo semaforoActivo = iterator.next();
            Led ledVerde = (Led) semaforoActivo.getLeds().get(2);

            if (ledVerde.getEstado() == 0) {
                ledVerde.getLbl().setBackground(new Color(0, 204, 0));
                // comunicarEstado("estado botón verde -> 1");
                ledVerde.setEstado(1);
            } else if (ledVerde.getEstado() == 1) {
                ledVerde.getLbl().setBackground(new Color(0, 145, 0));
                // comunicarEstado("estado botón verde -> 0");
                ledVerde.setEstado(0);
            } else {
                // led dañado
                // comunicarEstado("estado botón verde -> dañado");
            }
        }

    }
}
