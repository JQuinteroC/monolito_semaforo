package presentacion;

import presentacion.componentesGraficos.JLabelRound;
import java.awt.*;
import javax.swing.*;

public class Vista extends javax.swing.JFrame {

    private Modelo modelo;
    private Control control;

    private JButton btnRojo;
    private JButton btnAmarillo;
    private JButton btnVerde;

    private JLabelRound led1Gp1;
    private JLabelRound led2Gp1;
    private JLabelRound led3Gp1;

    private JLabelRound led1Gp2;
    private JLabelRound led2Gp2;
    private JLabelRound led3Gp2;

    private JComboBox selectorSemaforo;

    public Vista(Modelo m) {
        modelo = m;
        init();
        cargarEventos();
    }

    private void cargarEventos() {
        btnRojo.addActionListener(getControl());
        btnAmarillo.addActionListener(getControl());
        btnVerde.addActionListener(getControl());
        selectorSemaforo.addActionListener(getControl());
    }

    public void init() {

        Label fondoSemaforo1 = new Label();
        Label fondoSemaforo2 = new Label();
        // Gp 1
        led1Gp1 = new JLabelRound();// Rojo
        led2Gp1 = new JLabelRound();// Amarillo
        led3Gp1 = new JLabelRound();// Verde
        // Gp 2
        led1Gp2 = new JLabelRound();// Rojo
        led2Gp2 = new JLabelRound();// Amarillo
        led3Gp2 = new JLabelRound();// Verde

        btnRojo = new JButton("On/Off rojo");
        btnAmarillo = new JButton("On/Off amarillo");
        btnVerde = new JButton("On/Off verde");

        Container ventana = getContentPane();
        ventana.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LEDS semaforo 1
        ventana.add(led1Gp1);
        led1Gp1.setBounds(10, 50, 50, 50);
        led1Gp1.setBackground(new Color(186, 0, 0));
//        led1.setBackground(new Color(186, 0, 0));

        led2Gp1.setBounds(10, 110, 50, 50);
//        led2.setBackground(new Color(255, 255, 0));
        led2Gp1.setBackground(new Color(186, 186, 0));
        ventana.add(led2Gp1);

        led3Gp1.setBounds(10, 170, 50, 50);
//        led3.setBackground(new Color(0, 204, 0));
        led3Gp1.setBackground(new Color(0, 145, 0));
        ventana.add(led3Gp1);

        fondoSemaforo1.setBounds(8, 48, 54, 180);
        fondoSemaforo1.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo1);

        // LEDS semaforo 2
        ventana.add(led1Gp2);
        led1Gp2.setBounds(252, 50, 50, 50);
        led1Gp2.setBackground(new Color(186, 0, 0));
//        led1.setBackground(new Color(186, 0, 0));

        ventana.add(led2Gp2);
        led2Gp2.setBounds(252, 110, 50, 50);
//        led2.setBackground(new Color(255, 255, 0));
        led2Gp2.setBackground(new Color(186, 186, 0));

        ventana.add(led3Gp2);
        led3Gp2.setBounds(252, 170, 50, 50);
//        led3.setBackground(new Color(0, 204, 0));
        led3Gp2.setBackground(new Color(0, 145, 0));

        fondoSemaforo2.setBounds(250, 48, 54, 180);
        fondoSemaforo2.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo2);

        // Botón cambio de estado verde
        ventana.add(btnVerde);
        btnVerde.setBounds(80, 170, 150, 30);

        // Botón cambio de estado amarillo
        ventana.add(btnAmarillo);
        btnAmarillo.setBounds(80, 110, 150, 30);

        // Botón cambio de estado rojo
        ventana.add(btnRojo);
        btnRojo.setBounds(80, 50, 150, 30);

        selectorSemaforo = new JComboBox();
        selectorSemaforo.addItem("Grupo 1");
        selectorSemaforo.addItem("Grupo 2");
        selectorSemaforo.setBounds(80, 4, 150, 30);
        ventana.add(selectorSemaforo);

        ventana.setVisible(true);
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

    public JLabel getLed1() {
        return led1Gp1;
    }

    public JLabel getLed2() {
        return led2Gp1;
    }

    public JLabelRound getLed3() {
        return led3Gp1;
    }

    public JLabel getLed4() {
        return led1Gp2;
    }

    public JLabel getLed5() {
        return led2Gp2;
    }

    public JLabelRound getLed6() {
        return led3Gp2;
    }

    public JButton getBtnRojo() {
        return btnRojo;
    }

    public JButton getBtnAmarillo() {
        return btnAmarillo;
    }

    public JButton getBtnVerde() {
        return btnVerde;
    }

    public JComboBox getSelectorSemaforo() {
        return selectorSemaforo;
    }

}
