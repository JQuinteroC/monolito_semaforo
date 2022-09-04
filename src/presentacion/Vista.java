package presentacion;

import java.awt.*;
import javax.swing.*;

public class Vista extends javax.swing.JFrame {

    private Modelo modelo;
    private Control control;

    private JButton btnCambio;
    private JLabelRound led1;
    private JLabelRound led2;
    private JLabelRound led3;

    public Vista(Modelo m) {
        modelo = m;
        init();
        cargarEventos();
    }

    private void cargarEventos() {
        btnCambio.addActionListener(getControl());
    }

    public void init() {

        Label semaforo = new Label();
        led1 = new JLabelRound();// Rojo
        led2 = new JLabelRound();// Amarillo
        led3 = new JLabelRound();// Verde
        btnCambio = new JButton("Cambiar estado");

        Container c = getContentPane();
        c.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LEDS semaforo 1
        c.add(led1);
        led1.setBounds(10, 10, 50, 50);
        led1.setBackground(new Color(255, 0, 0));
//        led1.setBackground(new Color(186, 0, 0));


        c.add(led2);
        led2.setBounds(10, 70, 50, 50);
//        led2.setBackground(new Color(255, 255, 0));
        led2.setBackground(new Color(186, 186, 0));

        
        c.add(led3);
        led3.setBounds(10, 130, 50, 50);
//        led3.setBackground(new Color(0, 204, 0));
        led3.setBackground(new Color(0, 145, 0));

        
        c.add(semaforo);
        semaforo.setBounds(8, 8, 54, 180);
        semaforo.setBackground(Color.BLACK);
        
        // Botón cambio de estado
        c.add(btnCambio);
        btnCambio.setBounds(80, 70, 150, 30);
        
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

    public JLabelRound getLed1() {
        return led1;
    }

    public JLabelRound getLed2() {
        return led2;
    }

    public JLabelRound getLed3() {
        return led3;
    }
}
