package presentacion;

import java.awt.*;
import javax.swing.*;

public class Vista extends javax.swing.JFrame {

    private Modelo modelo;
    private Control control;

    public Vista(Modelo m) {
        modelo = m;
        init();
    }

    public void init() {

        JLabelRound com = new JLabelRound();

        Container c = getContentPane();
        c.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.add(com);
        com.setBounds(0, 0, 30, 30);
        com.setBackground(Color.red);

        c.setVisible(true);

    }

    public Modelo getModelo() {
        return modelo;
    }

    public Control getControl() {
        if (control == null) {
            control = new Control(this);
        }
        return control;
    }
}
