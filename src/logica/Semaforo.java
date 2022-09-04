package logica;

public class Semaforo {
    private int estado;
    // 0 - Rojo
    // 1 - Amarrillo
    // 2 - Verde

    public Semaforo() {
        estado = 0;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}