package presentacion;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;


public class Vista extends javax.swing.JFrame {

    private Modelo modelo;
    private Control control;
    
    public Vista(Modelo m) {
        modelo = m;
        initComponents();
        capturarEventos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sliTemp = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        pbrTemperatura = new javax.swing.JProgressBar();
        lblTemperatura = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Variacion temp");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 70, 130, 30);

        sliTemp.setMajorTickSpacing(10);
        sliTemp.setMaximum(250);
        sliTemp.setMinorTickSpacing(1);
        sliTemp.setPaintLabels(true);
        sliTemp.setPaintTicks(true);
        sliTemp.setValue(0);
        getContentPane().add(sliTemp);
        sliTemp.setBounds(200, 70, 930, 60);

        jLabel2.setText("Temperatura");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 320, 120, 50);

        pbrTemperatura.setMaximum(250);
        getContentPane().add(pbrTemperatura);
        pbrTemperatura.setBounds(90, 400, 900, 50);

        lblTemperatura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblTemperatura);
        lblTemperatura.setBounds(1040, 400, 90, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Modelo getModelo() {
        return modelo;
    }

    public Control getControl() {
        if(control == null){
            control = new Control(this);
        }
        return control;
    }
        
    private void capturarEventos() {
        sliTemp.addChangeListener(getControl());
    }

    public JLabel getLblTemperatura() {
        return lblTemperatura;
    }

    public JProgressBar getPbrTemperatura() {
        return pbrTemperatura;
    }

    public JSlider getSliTemp() {
        return sliTemp;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTemperatura;
    private javax.swing.JProgressBar pbrTemperatura;
    private javax.swing.JSlider sliTemp;
    // End of variables declaration//GEN-END:variables

}
