package presentacion;

import logica.Semaforo;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Led;

public class Modelo {

    private Semaforo sistema1;
    private Semaforo sistema2;
    private Semaforo sistema3;
    private Semaforo sistema4;
    private Semaforo sistema5;
    private Semaforo sistema6;
    private Semaforo sistema7;
    private Semaforo sistema8;
    private Semaforo sistemaP1;
    private Semaforo sistemaP2;
    private Semaforo sistemaActivo;

    private Vista ventana;

    public void iniciar() {
        // codigo de inicio de app
        getVentana().setSize(445, 720);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);

        // LEDs del Semaforo 1
        ArrayList<Led> leds1 = new ArrayList<Led>();
        leds1.add(new Led(getVentana().getLblSemaforo1().get(0), 0));
        leds1.add(new Led(getVentana().getLblSemaforo1().get(1), 0));
        leds1.add(new Led(getVentana().getLblSemaforo1().get(2), 0));

        // LEDs del Semaforo 2
        ArrayList<Led> leds2 = new ArrayList<Led>();
        leds2.add(new Led(getVentana().getLblSemaforo2().get(0), 0));
        leds2.add(new Led(getVentana().getLblSemaforo2().get(1), 0));
        leds2.add(new Led(getVentana().getLblSemaforo2().get(2), 0));

        // LEDs del Semaforo 3
        ArrayList<Led> leds3 = new ArrayList<Led>();
        leds3.add(new Led(getVentana().getLblSemaforo3().get(0), 0));
        leds3.add(new Led(getVentana().getLblSemaforo3().get(1), 0));
        leds3.add(new Led(getVentana().getLblSemaforo3().get(2), 0));

        // LEDs del Semaforo 4
        ArrayList<Led> leds4 = new ArrayList<Led>();
        leds4.add(new Led(getVentana().getLblSemaforo4().get(0), 0));
        leds4.add(new Led(getVentana().getLblSemaforo4().get(1), 0));
        leds4.add(new Led(getVentana().getLblSemaforo4().get(2), 0));

        // LEDs del Semaforo Peatonal 1
        ArrayList<Led> ledsPeatonal1 = new ArrayList<Led>();
        ledsPeatonal1.add(new Led(getVentana().getLblSemaforoPeatonal1().get(0), 0));
        ledsPeatonal1.add(new Led(getVentana().getLblSemaforoPeatonal1().get(1), 0));

        // LEDs del Semaforo 5
        ArrayList<Led> leds5 = new ArrayList<Led>();
        leds5.add(new Led(getVentana().getLblSemaforo5().get(0), 0));
        leds5.add(new Led(getVentana().getLblSemaforo5().get(1), 0));
        leds5.add(new Led(getVentana().getLblSemaforo5().get(2), 0));

        // LEDs del Semaforo 6
        ArrayList<Led> leds6 = new ArrayList<Led>();
        leds6.add(new Led(getVentana().getLblSemaforo6().get(0), 0));
        leds6.add(new Led(getVentana().getLblSemaforo6().get(1), 0));
        leds6.add(new Led(getVentana().getLblSemaforo6().get(2), 0));

        // LEDs del Semaforo 7
        ArrayList<Led> leds7 = new ArrayList<Led>();
        leds7.add(new Led(getVentana().getLblSemaforo7().get(0), 0));
        leds7.add(new Led(getVentana().getLblSemaforo7().get(1), 0));
        leds7.add(new Led(getVentana().getLblSemaforo7().get(2), 0));

        // LEDs del Semaforo 8
        ArrayList<Led> leds8 = new ArrayList<Led>();
        leds8.add(new Led(getVentana().getLblSemaforo8().get(0), 0));
        leds8.add(new Led(getVentana().getLblSemaforo8().get(1), 0));
        leds8.add(new Led(getVentana().getLblSemaforo8().get(2), 0));

        // LEDs del Semaforo Peatonal 2
        ArrayList<Led> ledsPeatonal2 = new ArrayList<Led>();
        ledsPeatonal2.add(new Led(getVentana().getLblSemaforoPeatonal2().get(0), 0));
        ledsPeatonal2.add(new Led(getVentana().getLblSemaforoPeatonal2().get(1), 0));

        // Crear los semaforos
        sistema1 = new Semaforo();
        sistema2 = new Semaforo();
        sistema3 = new Semaforo();
        sistema4 = new Semaforo();
        sistema5 = new Semaforo();
        sistema6 = new Semaforo();
        sistema7 = new Semaforo();
        sistema8 = new Semaforo();
        sistemaP1 = new Semaforo();
        sistemaP2 = new Semaforo();

        sistemaActivo = sistema1;

        sistema1.setLeds(leds1);
        sistema2.setLeds(leds2);
        sistema3.setLeds(leds3);
        sistema4.setLeds(leds4);
        sistema5.setLeds(leds5);
        sistema6.setLeds(leds6);
        sistema7.setLeds(leds7);
        sistema8.setLeds(leds8);
        sistemaP1.setLeds(ledsPeatonal1);
        sistemaP2.setLeds(ledsPeatonal2);
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

    public Semaforo getSistema3() {
        return sistema3;
    }

    public void setSistema3(Semaforo sistema3) {
        this.sistema3 = sistema3;
    }

    public Semaforo getSistema4() {
        return sistema4;
    }

    public void setSistema4(Semaforo sistema4) {
        this.sistema4 = sistema4;
    }

    public Semaforo getSistema5() {
        return sistema5;
    }

    public void setSistema5(Semaforo sistema5) {
        this.sistema5 = sistema5;
    }

    public Semaforo getSistema6() {
        return sistema6;
    }

    public void setSistema6(Semaforo sistema6) {
        this.sistema6 = sistema6;
    }

    public Semaforo getSistema7() {
        return sistema7;
    }

    public void setSistema7(Semaforo sistema7) {
        this.sistema7 = sistema7;
    }

    public Semaforo getSistema8() {
        return sistema8;
    }

    public void setSistema8(Semaforo sistema8) {
        this.sistema8 = sistema8;
    }

    public Semaforo getSistemaP1() {
        return sistemaP1;
    }

    public void setSistemaP1(Semaforo sistemaP1) {
        this.sistemaP1 = sistemaP1;
    }

    public Semaforo getSistemaP2() {
        return sistemaP2;
    }

    public void setSistemaP2(Semaforo sistemaP2) {
        this.sistemaP2 = sistemaP2;
    }

    void cambioEstadoRojo() {
        Led ledRojo = (Led) sistemaActivo.getLeds().get(0);

        // Si es un semaforo peatonal
        if (sistemaActivo.getLeds().size() == 2) {

            if (ledRojo.getEstado() == 0) {
                ledRojo.getLbl().setIcon(ventana.getImgRedOn());
                ventana.getBtnRojo().setIcon(ventana.getImgOn());
                ledRojo.setEstado(1);
            } else if (ledRojo.getEstado() == 1) {
                ledRojo.getLbl().setIcon(ventana.getImgRedOff());
                ventana.getBtnRojo().setIcon(ventana.getImgOff());
                ledRojo.setEstado(0);
            } else {
                JOptionPane.showMessageDialog(null, "El LED esta dañado");
            }

        } else {
            if (ledRojo.getEstado() == 0) {
                ledRojo.getLbl().setBackground(new Color(255, 0, 0));
                ventana.getBtnRojo().setIcon(ventana.getImgOn());
                ledRojo.setEstado(1);
            } else if (ledRojo.getEstado() == 1) {
                ledRojo.getLbl().setBackground(new Color(100, 0, 0));
                ventana.getBtnRojo().setIcon(ventana.getImgOff());
                ledRojo.setEstado(0);
            } else {
                JOptionPane.showMessageDialog(null, "El LED esta dañado");
            }
        }

    }

    void cambioEstadoAmarillo() {
        Led ledAmarillo = (Led) sistemaActivo.getLeds().get(1);

        if (ledAmarillo.getEstado() == 0) {
            ledAmarillo.getLbl().setBackground(new Color(255, 255, 0));
            ventana.getBtnAmarillo().setIcon(ventana.getImgOn());
            ledAmarillo.setEstado(1);
        } else if (ledAmarillo.getEstado() == 1) {
            ledAmarillo.getLbl().setBackground(new Color(100, 100, 0));
            ventana.getBtnAmarillo().setIcon(ventana.getImgOff());
            ledAmarillo.setEstado(0);
        } else {
            JOptionPane.showMessageDialog(null, "El LED esta dañado");
        }

    }

    void cambioEstadoVerde() {
        int size = sistemaActivo.getLeds().size();
        Led ledVerde = (Led) sistemaActivo.getLeds().get(size-1);

        if (size == 2) {
            if (ledVerde.getEstado() == 0) {
                ledVerde.getLbl().setIcon(ventana.getImgGreenOn());
                ventana.getBtnVerde().setIcon(ventana.getImgOn());
                ledVerde.setEstado(1);
            } else if (ledVerde.getEstado() == 1) {
                ledVerde.getLbl().setIcon(ventana.getImgGreenOff());
                ventana.getBtnVerde().setIcon(ventana.getImgOff());
                ledVerde.setEstado(0);
            } else {
                JOptionPane.showMessageDialog(null, "El LED esta dañado");
            }
        } else {
            
            if (ledVerde.getEstado() == 0) {
                ledVerde.getLbl().setBackground(new Color(0, 204, 0));
                ventana.getBtnVerde().setIcon(ventana.getImgOn());
                ledVerde.setEstado(1);
            } else if (ledVerde.getEstado() == 1) {
                ledVerde.getLbl().setBackground(new Color(0, 100, 0));
                ventana.getBtnVerde().setIcon(ventana.getImgOff());
                ledVerde.setEstado(0);
            } else {
                JOptionPane.showMessageDialog(null, "El LED esta dañado");
            }
        }
    }

    void comprobarEstadoBotones() {
        int size = sistemaActivo.getLeds().size();
        ArrayList<Led> leds = sistemaActivo.getLeds();
        ventana.getBtnAmarillo().setVisible(true);

        if (leds.get(0).getEstado() == 0) {
            ventana.getBtnRojo().setIcon(ventana.getImgOff());
        } else {
            ventana.getBtnRojo().setIcon(ventana.getImgOn());
        }

        //Peatonal
        if (size == 2) {
            ventana.getBtnAmarillo().setVisible(false);

            if (leds.get(1).getEstado() == 0) {
                ventana.getBtnVerde().setIcon(ventana.getImgOff());
            } else {
                ventana.getBtnVerde().setIcon(ventana.getImgOn());
            }

        } else {
            if (leds.get(1).getEstado() == 0) {
                ventana.getBtnAmarillo().setIcon(ventana.getImgOff());
            } else {
                ventana.getBtnAmarillo().setIcon(ventana.getImgOn());
            }

            if (leds.get(2).getEstado() == 0) {
                ventana.getBtnVerde().setIcon(ventana.getImgOff());
            } else {
                ventana.getBtnVerde().setIcon(ventana.getImgOn());
            }
        }

    }

}
