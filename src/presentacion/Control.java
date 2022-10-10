package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Semaforo;
import logica.SemaforoPeatonal;

public class Control implements ActionListener {

    private Vista ventana;
    private Modelo modelo;

    public Control(Vista aThis) {
        ventana = aThis;
        modelo = ventana.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnDanarLed()) {
            int index = 0;
            if (ventana.getSelectorSemaforo().getSelectedIndex() == 0 || ventana.getSelectorSemaforo().getSelectedIndex() == 1) {
                buscarDanar(index, ventana.getSelectorSemaforo().getSelectedIndex() == 0);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 2 || ventana.getSelectorSemaforo().getSelectedIndex() == 3) {
                index = 1;
                buscarDanar(index, ventana.getSelectorSemaforo().getSelectedIndex() == 2);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 4 || ventana.getSelectorSemaforo().getSelectedIndex() == 5) {
                index = 2;
                buscarDanar(index, ventana.getSelectorSemaforo().getSelectedIndex() == 4);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 6 || ventana.getSelectorSemaforo().getSelectedIndex() == 7) {
                index = 3;
                buscarDanar(index, ventana.getSelectorSemaforo().getSelectedIndex() == 6);
            } else if (ventana.getSelectorSemaforo().getSelectedIndex() == 8 || ventana.getSelectorSemaforo().getSelectedIndex() == 9) {
                boolean primero = ventana.getSelectorSemaforo().getSelectedIndex() == 8;
                for (int i = 0; i < modelo.getTarjetas().size(); i++) {
                    for (int j = 0; j < modelo.getTarjeta(i).getGrupo().size(); j++) {
                        Semaforo semaforo = modelo.getTarjeta(i).getGrupo().get(j);
                        if (semaforo.getClass() == SemaforoPeatonal.class && primero) {
                            semaforo.danar();
                        } else if (semaforo.getClass() == SemaforoPeatonal.class) {
                            primero = true;
                        }
                    }
                }
            }
        }
    }

    public void buscarDanar(int index, boolean primero) {
        for (int j = 0; j < modelo.getTarjeta(index).getGrupo().size(); j++) {
            Semaforo semaforo = modelo.getTarjeta(index).getGrupo().get(j);
            if (semaforo.getClass() != SemaforoPeatonal.class && primero) {
                semaforo.danar();
                break;
            } else if (semaforo.getClass() != SemaforoPeatonal.class) {
                primero = true;
            }
            if (j == modelo.getTarjeta(index).getGrupo().size() - 1) {
                j = -1;
                index++;
                if (index >= modelo.getTarjetas().size()) {
                    System.out.println("no se pudo dañar el semanforo");
                    break;
                }
            }
        }
    }
}
