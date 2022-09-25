package presentacion;

import logica.Semaforo;

import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Led;

public class Modelo {

    private Semaforo sistema1;
    private Semaforo sistema2;
    private Semaforo sistemaActivo;

    private Vista ventana;

    private String ip = "192.168.39.176";
    private int port = 9999;

    public void iniciar() {
        // codigo de inicio de app
        getVentana().setSize(350, 300);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);

        ArrayList<Led> leds1 = new ArrayList<Led>();
        leds1.add(new Led(getVentana().getLed1(), 0));
        leds1.add(new Led(getVentana().getLed2(), 0));
        leds1.add(new Led(getVentana().getLed3(), 0));

        ArrayList<Led> leds2 = new ArrayList<Led>();
        leds2.add(new Led(getVentana().getLed4(), 0));
        leds2.add(new Led(getVentana().getLed5(), 0));
        leds2.add(new Led(getVentana().getLed6(), 0));

        sistema1 = new Semaforo();
        sistema2 = new Semaforo();
        sistemaActivo = sistema1;

        sistema1.setLeds(leds1);
        sistema2.setLeds(leds2);

    }

    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }

    public Semaforo getSistemaActivo() {
        return sistemaActivo;
    }

    public void setSistemaActivo(Semaforo sistemaActivo) {
        this.sistemaActivo = sistemaActivo;
    }

    public Semaforo getSistema1() {
        return sistema1;
    }

    public void setSistema1(Semaforo sistema1) {
        this.sistema1 = sistema1;
    }

    public Semaforo getSistema2() {
        return sistema2;
    }

    public void setSistema2(Semaforo sistema2) {
        this.sistema2 = sistema2;
    }

    void cambioEstadoRojo() {
        Led ledRojo = (Led) sistemaActivo.getLeds().get(0);

        if (ledRojo.getEstado() == 0) {
            ledRojo.getLbl().setBackground(new Color(255, 0, 0));
            ventana.getBtnRojo().setIcon(ventana.getImgOn());
            comunicarEstado("estado botón rojo -> 1");
            ledRojo.setEstado(1);
        } else if (ledRojo.getEstado() == 1) {
            ledRojo.getLbl().setBackground(new Color(186, 0, 0));
            ventana.getBtnRojo().setIcon(ventana.getImgOff());
            comunicarEstado("estado botón rojo -> 0");
            ledRojo.setEstado(0);
        } else {
            JOptionPane.showMessageDialog(null, "El LED esta dañado");
            comunicarEstado("estado botón rojo -> dañado");
        }

    }

    void cambioEstadoAmarillo() {
        Led ledAmarillo = (Led) sistemaActivo.getLeds().get(1);

        if (ledAmarillo.getEstado() == 0) {
            ledAmarillo.getLbl().setBackground(new Color(255, 255, 0));
            ventana.getBtnAmarillo().setIcon(ventana.getImgOn());
            comunicarEstado("estado botón amarillo -> 1");
            ledAmarillo.setEstado(1);
        } else if (ledAmarillo.getEstado() == 1) {
            ledAmarillo.getLbl().setBackground(new Color(186, 186, 0));
            ventana.getBtnAmarillo().setIcon(ventana.getImgOff());
            comunicarEstado("estado botón amarillo -> 0");
            ledAmarillo.setEstado(0);
        } else {
            JOptionPane.showMessageDialog(null, "El LED esta dañado");
            comunicarEstado("estado botón amarillo -> dañado");
        }

    }

    void cambioEstadoVerde() {
        Led ledVerde = (Led) sistemaActivo.getLeds().get(2);

        if (ledVerde.getEstado() == 0) {
            ledVerde.getLbl().setBackground(new Color(0, 204, 0));
            ventana.getBtnVerde().setIcon(ventana.getImgOn());
            comunicarEstado("estado botón verde -> 1");
            ledVerde.setEstado(1);
        } else if (ledVerde.getEstado() == 1) {
            ledVerde.getLbl().setBackground(new Color(0, 145, 0));
            ventana.getBtnVerde().setIcon(ventana.getImgOff());
            comunicarEstado("estado botón verde -> 0");
            ledVerde.setEstado(0);
        } else {
            JOptionPane.showMessageDialog(null, "El LED esta dañado");
            comunicarEstado("estado botón verde -> dañado");
        }

    }

    void comprobarEstadoBotones() {
        ArrayList<Led> leds = sistemaActivo.getLeds();
        
        if(leds.get(0).getEstado() == 0)
            ventana.getBtnRojo().setIcon(ventana.getImgOff());
        else
            ventana.getBtnRojo().setIcon(ventana.getImgOn());
        
        if(leds.get(1).getEstado() == 0)
            ventana.getBtnAmarillo().setIcon(ventana.getImgOff());
        else
            ventana.getBtnAmarillo().setIcon(ventana.getImgOn());
        
    
        if(leds.get(2).getEstado() == 0)
            ventana.getBtnVerde().setIcon(ventana.getImgOff());
        else
            ventana.getBtnVerde().setIcon(ventana.getImgOn());
        
    }
    void comunicarEstado(String estado){
        System.out.println(estado);
        try{
            Socket suck = new Socket(ip, port);
            DataOutputStream flujo_salida = new DataOutputStream(suck.getOutputStream());
            flujo_salida.writeUTF("el estado es: "+estado);
            flujo_salida.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}


