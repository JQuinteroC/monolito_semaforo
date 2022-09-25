package logica;

import javax.swing.JLabel;

public class Led {

    private JLabel lbl;
    private int estado;
    // 0 - Rojo
    // 1 - Amarrillo
    // 2 - Verde

    public Led(JLabel lbl, int estado) {
        this.lbl = lbl;
        this.estado = estado;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {this.estado = estado;}

}
