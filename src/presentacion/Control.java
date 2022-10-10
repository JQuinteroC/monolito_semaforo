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
            modelo.getTarjeta().cambioEstadoRojo();
        } else if (e.getSource() == ventana.getBtnAmarillo()) {
            modelo.getTarjeta().cambioEstadoAmarillo();
        } else if (e.getSource() == ventana.getBtnVerde()) {
            modelo.getTarjeta().cambioEstadoVerde();
        }


    }

}
