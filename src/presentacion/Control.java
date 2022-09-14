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
            } else {
                modelo.setSistemaActivo(modelo.getSistema2());
            }
            modelo.comprobarEstadoBotones();
        }

    }
   
}
