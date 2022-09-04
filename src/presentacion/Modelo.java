package presentacion;

import logica.Semaforo;


public class Modelo {

    private Semaforo sistema;
    private Vista ventana;
    
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
//        float v = getVentana().getSliTemp().getValue();
//        getSistema().setTemperaturaActual(v);
        
//        getVentana().getPbrTemperatura().setValue((int) getSistema().getTemperaturaActual());
//        getVentana().getLblTemperatura().setText("" + getSistema().getTemperaturaActual());
    }
    
    
    
}
