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
//        if (e.getSource() == ventana.getBtnRojo()) {
////            modelo.getTarjeta().cambioEstadoRojo();
//        } else if (e.getSource() == ventana.getBtnAmarillo()) {
//            modelo.getTarjeta().cambioEstadoAmarillo();
//        } else if (e.getSource() == ventana.getBtnVerde()) {
//            modelo.getTarjeta().cambioEstadoVerde();
//        }
        if (e.getSource() == ventana.getBtnDanarLed()) {
            if (ventana.getSelectorSemaforo().getSelectedIndex() == 0) {
                modelo.getTarjeta(0).getGrupo().get(0).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 1) {
                modelo.getTarjeta(0).getGrupo().get(1).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 2) {
                modelo.getTarjeta(1).getGrupo().get(0).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 3) {
                modelo.getTarjeta(1).getGrupo().get(1).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 4) {
                modelo.getTarjeta(2).getGrupo().get(0).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 5) {
                modelo.getTarjeta(2).getGrupo().get(1).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 6) {
                modelo.getTarjeta(3).getGrupo().get(0).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 7) {
                modelo.getTarjeta(3).getGrupo().get(1).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 8) {
                modelo.getTarjeta(4).getGrupo().get(0).setEstado(1);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 9) {
                modelo.getTarjeta(4).getGrupo().get(1).setEstado(1);
            }
        }

    }

}
