package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {

    private Vista ventana;
    private Modelo modelo;

    public Control(Vista aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnRojo()) {
            modelo.cambioEstadoRojo();
        } else if (e.getSource() == ventana.getBtnAmarillo()) {
            modelo.cambioEstadoAmarillo();
        } else if (e.getSource() == ventana.getBtnVerde()) {
            modelo.cambioEstadoVerde();
        } else if (e.getSource() == ventana.getSelectorSemaforo()) {

            if (ventana.getSelectorSemaforo().getSelectedIndex() == 0) {
                modelo.setSistemaActivo(modelo.getSistema1());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 1) {
                modelo.setSistemaActivo(modelo.getSistema2());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 2) {
                modelo.setSistemaActivo(modelo.getSistema3());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 3) {
                modelo.setSistemaActivo(modelo.getSistema4());

            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 4) {
                modelo.setSistemaActivo(modelo.getSistema5());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 5) {
                modelo.setSistemaActivo(modelo.getSistema6());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 6) {
                modelo.setSistemaActivo(modelo.getSistema7());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 7) {
                modelo.setSistemaActivo(modelo.getSistema8());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 8) {
                modelo.setSistemaActivo(modelo.getSistemaP1());
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 9) {
                modelo.setSistemaActivo(modelo.getSistemaP2());
            }
            modelo.comprobarEstadoBotones();
        } else if (e.getSource() == ventana.getBtnDanarLed()){
            System.out.println("Led dañado");
        }


    }

}
