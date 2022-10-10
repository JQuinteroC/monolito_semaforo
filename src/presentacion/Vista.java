package presentacion;

import presentacion.componentesGraficos.JLabelRound;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Vista extends javax.swing.JFrame {

    private final Modelo modelo;
    private Control control;
    private ArrayList<ArrayList<JLabel>> semaforos;
    private ArrayList<ArrayList<JLabel>> semaforosPeatonales;

    private ArrayList<JLabel> lblSemaforo1;
    private ArrayList<JLabel> lblSemaforo2;
    private ArrayList<JLabel> lblSemaforo3;
    private ArrayList<JLabel> lblSemaforo4;
    private ArrayList<JLabel> lblSemaforo5;
    private ArrayList<JLabel> lblSemaforo6;
    private ArrayList<JLabel> lblSemaforo7;
    private ArrayList<JLabel> lblSemaforo8;
    private ArrayList<JLabel> lblSemaforoPeatonal1;
    private ArrayList<JLabel> lblSemaforoPeatonal2;

    private JButton btnDanarLed;

    private JLabelRound led1Sm1;
    private JLabelRound led2Sm1;
    private JLabelRound led3Sm1;

    private JLabelRound led1Sm2;
    private JLabelRound led2Sm2;
    private JLabelRound led3Sm2;

    private JLabelRound led1Sm3;
    private JLabelRound led2Sm3;
    private JLabelRound led3Sm3;

    private JLabelRound led1Sm4;
    private JLabelRound led2Sm4;
    private JLabelRound led3Sm4;

    private JLabelRound led1Sm5;
    private JLabelRound led2Sm5;
    private JLabelRound led3Sm5;

    private JLabelRound led1Sm6;
    private JLabelRound led2Sm6;
    private JLabelRound led3Sm6;

    private JLabelRound led1Sm7;
    private JLabelRound led2Sm7;
    private JLabelRound led3Sm7;

    private JLabelRound led1Sm8;
    private JLabelRound led2Sm8;
    private JLabelRound led3Sm8;

    private JLabelRound led1SmP1;
    private JLabelRound led2SmP1;
    private JLabelRound led1SmP2;
    private JLabelRound led2SmP2;

    private JComboBox selectorSemaforo;

    private ImageIcon imgOn;
    private ImageIcon imgOff;
    private ImageIcon imgGreenOn;
    private ImageIcon imgGreenOff;
    private ImageIcon imgRedOn;
    private ImageIcon imgRedOff;

    public Vista(Modelo m) {
        modelo = m;
        init();
        cargarEventos();
    }

    private void cargarEventos() {
        btnDanarLed.addActionListener(getControl());
        selectorSemaforo.addActionListener(getControl());
    }

    public void init() {

        Container ventana = getContentPane();
        ventana.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Carga de Iconos
        imgOn = new ImageIcon(new ImageIcon("resources/img/on.png")
                .getImage()
                .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING));
        imgOff = new ImageIcon(new ImageIcon("resources/img/off.png")
                .getImage()
                .getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING));
        imgGreenOn = new ImageIcon(new ImageIcon("resources/img/green_on.png")
                .getImage()
                .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        imgGreenOff = new ImageIcon(new ImageIcon("resources/img/green_off.png")
                .getImage()
                .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        imgRedOn = new ImageIcon(new ImageIcon("resources/img/red_on.png")
                .getImage()
                .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        imgRedOff = new ImageIcon(new ImageIcon("resources/img/red_off.png")
                .getImage()
                .getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        ImageIcon imgWarning = new ImageIcon(new ImageIcon("resources/img/warning.png")
                .getImage()
                .getScaledInstance(60, 60, Image.SCALE_AREA_AVERAGING));

        // Botones
        btnDanarLed = new JButton("Dañar LED");

        // Semaforo 1 
        lblSemaforo1 = new ArrayList<>();

        Label fondoSemaforo1 = new Label();
        led1Sm1 = new JLabelRound();// Rojo
        led2Sm1 = new JLabelRound();// Amarillo
        led3Sm1 = new JLabelRound();// Verde

        // LEDS Semaforo 1
        ventana.add(led1Sm1);
        led1Sm1.setBounds(10, 50, 50, 50);
        led1Sm1.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm1);
        led2Sm1.setBounds(10, 110, 50, 50);
        led2Sm1.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm1);
        led3Sm1.setBounds(10, 170, 50, 50);
        led3Sm1.setBackground(new Color(0, 100, 0));

        fondoSemaforo1.setBounds(8, 48, 54, 180);
        fondoSemaforo1.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo1);

        lblSemaforo1.add(led1Sm1);
        lblSemaforo1.add(led2Sm1);
        lblSemaforo1.add(led3Sm1);

        // Semaforo 2
        lblSemaforo2 = new ArrayList<>();
        Label fondoSemaforo2 = new Label();
        led1Sm2 = new JLabelRound();// Rojo
        led2Sm2 = new JLabelRound();// Amarillo
        led3Sm2 = new JLabelRound();// Verde

        // LEDS semaforo 2
        ventana.add(led1Sm2);
        led1Sm2.setBounds(102, 50, 50, 50);
        led1Sm2.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm2);
        led2Sm2.setBounds(102, 110, 50, 50);
        led2Sm2.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm2);
        led3Sm2.setBounds(102, 170, 50, 50);
        led3Sm2.setBackground(new Color(0, 100, 0));

        fondoSemaforo2.setBounds(100, 48, 54, 180);
        fondoSemaforo2.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo2);

        lblSemaforo2.add(led1Sm2);
        lblSemaforo2.add(led2Sm2);
        lblSemaforo2.add(led3Sm2);

        // Semaforo 3
        lblSemaforo3 = new ArrayList<>();
        Label fondoSemaforo3 = new Label();
        led1Sm3 = new JLabelRound();// Rojo
        led2Sm3 = new JLabelRound();// Amarillo
        led3Sm3 = new JLabelRound();// Verde

        // LEDS semaforo 3
        ventana.add(led1Sm3);
        led1Sm3.setBounds(192, 50, 50, 50);
        led1Sm3.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm3);
        led2Sm3.setBounds(192, 110, 50, 50);
        led2Sm3.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm3);
        led3Sm3.setBounds(192, 170, 50, 50);
        led3Sm3.setBackground(new Color(0, 100, 0));

        fondoSemaforo3.setBounds(190, 48, 54, 180);
        fondoSemaforo3.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo3);

        lblSemaforo3.add(led1Sm3);
        lblSemaforo3.add(led2Sm3);
        lblSemaforo3.add(led3Sm3);

        // Semaforo 4
        lblSemaforo4 = new ArrayList<>();
        Label fondoSemaforo4 = new Label();
        led1Sm4 = new JLabelRound();// Rojo
        led2Sm4 = new JLabelRound();// Amarillo
        led3Sm4 = new JLabelRound();// Verde

        // LEDS semaforo 4
        ventana.add(led1Sm4);
        led1Sm4.setBounds(282, 50, 50, 50);
        led1Sm4.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm4);
        led2Sm4.setBounds(282, 110, 50, 50);
        led2Sm4.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm4);
        led3Sm4.setBounds(282, 170, 50, 50);
        led3Sm4.setBackground(new Color(0, 100, 0));

        fondoSemaforo4.setBounds(280, 48, 54, 180);
        fondoSemaforo4.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo4);

        lblSemaforo4.add(led1Sm4);
        lblSemaforo4.add(led2Sm4);
        lblSemaforo4.add(led3Sm4);

        // Semaforo Peatonal 1
        lblSemaforoPeatonal1 = new ArrayList<>();
        Label fondoSemaforoPeatonal1 = new Label();
        led1SmP1 = new JLabelRound();// Rojo
        led2SmP1 = new JLabelRound();// Verde

        // LEDS Semaforo Peatonal 1
        ventana.add(led1SmP1);
        led1SmP1.setBounds(372, 50, 50, 50);
        led1SmP1.setBackground(new Color(100, 0, 0));
        led1SmP1.setIcon(imgRedOff);

        ventana.add(led2SmP1);
        led2SmP1.setBounds(372, 110, 50, 50);
        led2SmP1.setBackground(new Color(100, 100, 0));
        led2SmP1.setIcon(imgGreenOff);

        fondoSemaforoPeatonal1.setBounds(370, 48, 54, 120);
        fondoSemaforoPeatonal1.setBackground(Color.BLACK);
        ventana.add(fondoSemaforoPeatonal1);

        lblSemaforoPeatonal1.add(led1SmP1);
        lblSemaforoPeatonal1.add(led2SmP1);

        // Semaforo 5 
        lblSemaforo5 = new ArrayList<>();
        Label fondoSemaforo5 = new Label();
        led1Sm5 = new JLabelRound();// Rojo
        led2Sm5 = new JLabelRound();// Amarillo
        led3Sm5 = new JLabelRound();// Verde

        // LEDS Semaforo 5
        ventana.add(led1Sm5);
        led1Sm5.setBounds(10, 260, 50, 50);
        led1Sm5.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm5);
        led2Sm5.setBounds(10, 320, 50, 50);
        led2Sm5.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm5);
        led3Sm5.setBounds(10, 380, 50, 50);
        led3Sm5.setBackground(new Color(0, 100, 0));

        fondoSemaforo5.setBounds(8, 258, 54, 180);
        fondoSemaforo5.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo5);

        lblSemaforo5.add(led1Sm5);
        lblSemaforo5.add(led2Sm5);
        lblSemaforo5.add(led3Sm5);

        // Semaforo 6
        lblSemaforo6 = new ArrayList<>();
        Label fondoSemaforo6 = new Label();
        led1Sm6 = new JLabelRound();// Rojo
        led2Sm6 = new JLabelRound();// Amarillo
        led3Sm6 = new JLabelRound();// Verde

        // LEDS Semaforo 5
        ventana.add(led1Sm6);
        led1Sm6.setBounds(102, 260, 50, 50);
        led1Sm6.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm6);
        led2Sm6.setBounds(102, 320, 50, 50);
        led2Sm6.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm6);
        led3Sm6.setBounds(102, 380, 50, 50);
        led3Sm6.setBackground(new Color(0, 100, 0));

        fondoSemaforo6.setBounds(100, 258, 54, 180);
        fondoSemaforo6.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo6);

        lblSemaforo6.add(led1Sm6);
        lblSemaforo6.add(led2Sm6);
        lblSemaforo6.add(led3Sm6);

        // Semaforo 7
        lblSemaforo7 = new ArrayList<>();
        Label fondoSemaforo7 = new Label();
        led1Sm7 = new JLabelRound();// Rojo
        led2Sm7 = new JLabelRound();// Amarillo
        led3Sm7 = new JLabelRound();// Verde

        // LEDS Semaforo 7
        ventana.add(led1Sm7);
        led1Sm7.setBounds(192, 260, 50, 50);
        led1Sm7.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm7);
        led2Sm7.setBounds(192, 320, 50, 50);
        led2Sm7.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm7);
        led3Sm7.setBounds(192, 380, 50, 50);
        led3Sm7.setBackground(new Color(0, 100, 0));

        fondoSemaforo7.setBounds(190, 258, 54, 180);
        fondoSemaforo7.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo7);

        lblSemaforo7.add(led1Sm7);
        lblSemaforo7.add(led2Sm7);
        lblSemaforo7.add(led3Sm7);

        // Semaforo 8
        lblSemaforo8 = new ArrayList<>();
        Label fondoSemaforo8 = new Label();
        led1Sm8 = new JLabelRound();// Rojo
        led2Sm8 = new JLabelRound();// Amarillo
        led3Sm8 = new JLabelRound();// Verde

        // LEDS semaforo 8
        ventana.add(led1Sm8);
        led1Sm8.setBounds(282, 260, 50, 50);
        led1Sm8.setBackground(new Color(100, 0, 0));

        ventana.add(led2Sm8);
        led2Sm8.setBounds(282, 320, 50, 50);
        led2Sm8.setBackground(new Color(100, 100, 0));

        ventana.add(led3Sm8);
        led3Sm8.setBounds(282, 380, 50, 50);
        led3Sm8.setBackground(new Color(0, 100, 0));

        fondoSemaforo8.setBounds(280, 258, 54, 180);
        fondoSemaforo8.setBackground(Color.BLACK);
        ventana.add(fondoSemaforo8);

        lblSemaforo8.add(led1Sm8);
        lblSemaforo8.add(led2Sm8);
        lblSemaforo8.add(led3Sm8);

        // Semaforo Peatonal 2
        lblSemaforoPeatonal2 = new ArrayList<>();
        Label fondoSemaforoPeatonal2 = new Label();
        led1SmP2 = new JLabelRound();// Rojo
        led2SmP2 = new JLabelRound();// Verde

        // LEDS Semaforo Peatonal 1
        ventana.add(led1SmP2);
        led1SmP2.setBounds(372, 260, 50, 50);
        led1SmP2.setBackground(new Color(100, 0, 0));
        led1SmP2.setIcon(imgRedOff);

        ventana.add(led2SmP2);
        led2SmP2.setBounds(372, 320, 50, 50);
        led2SmP2.setBackground(new Color(100, 100, 0));
        led2SmP2.setIcon(imgGreenOff);

        fondoSemaforoPeatonal2.setBounds(370, 258, 54, 120);
        fondoSemaforoPeatonal2.setBackground(Color.BLACK);
        ventana.add(fondoSemaforoPeatonal2);

        lblSemaforoPeatonal2.add(led1SmP2);
        lblSemaforoPeatonal2.add(led2SmP2);

        // Botón dañar semáforo btnDanarLed
        ventana.add(btnDanarLed);
        btnDanarLed.setBounds(130, 510, 150, 60);
        btnDanarLed.setIcon(imgWarning);
        btnDanarLed.setFocusable(false);
        btnDanarLed.setContentAreaFilled(false);
        btnDanarLed.setBorder(null);

        selectorSemaforo = new JComboBox();
        selectorSemaforo.addItem("Semaforo 1");
        selectorSemaforo.addItem("Semaforo 2");
        selectorSemaforo.addItem("Semaforo 3");
        selectorSemaforo.addItem("Semaforo 4");
        selectorSemaforo.addItem("Semaforo 5");
        selectorSemaforo.addItem("Semaforo 6");
        selectorSemaforo.addItem("Semaforo 7");
        selectorSemaforo.addItem("Semaforo 8");
        selectorSemaforo.addItem("Semaforo Peatonal 1");
        selectorSemaforo.addItem("Semaforo Peatonal 2");
        selectorSemaforo.setBounds(60, 470, 300, 30);
        ventana.add(selectorSemaforo);

        semaforos = new ArrayList<>();
        semaforos.add(lblSemaforo1);
        semaforos.add(lblSemaforo2);
        semaforos.add(lblSemaforo3);
        semaforos.add(lblSemaforo4);
        semaforos.add(lblSemaforo5);
        semaforos.add(lblSemaforo6);
        semaforos.add(lblSemaforo7);
        semaforos.add(lblSemaforo8);

        semaforosPeatonales = new ArrayList<>();
        semaforosPeatonales.add(lblSemaforoPeatonal1);
        semaforosPeatonales.add(lblSemaforoPeatonal2);
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

    public ArrayList<ArrayList<JLabel>> getSemaforos() {
        return semaforos;
    }

    public ArrayList<ArrayList<JLabel>> getSemaforosPeatonales() {
        return semaforosPeatonales;
    }

    public JButton getBtnDanarLed() {
        return btnDanarLed;
    }

    public JComboBox getSelectorSemaforo() {
        return selectorSemaforo;
    }

    public ImageIcon getImgOn() {
        return imgOn;
    }

    public ImageIcon getImgOff() {
        return imgOff;
    }

    public ImageIcon getImgGreenOn() {
        return imgGreenOn;
    }

    public ImageIcon getImgGreenOff() {
        return imgGreenOff;
    }

    public ImageIcon getImgRedOn() {
        return imgRedOn;
    }

    public ImageIcon getImgRedOff() {
        return imgRedOff;
    }

}
