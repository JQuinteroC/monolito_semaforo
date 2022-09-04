package presentacion;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Control implements ChangeListener{

    private Vista ventana;
    private Modelo modelo;
    
    public Control(Vista aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        modelo.registrarTemperaturaAmbiente();
    }
        
}
